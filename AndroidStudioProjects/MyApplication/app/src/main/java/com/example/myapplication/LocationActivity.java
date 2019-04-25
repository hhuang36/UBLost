package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IAOrientationListener;
import com.indooratlas.android.sdk.IAOrientationRequest;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk.IARoute;
import com.indooratlas.android.sdk.IAWayfindingListener;
import com.indooratlas.android.sdk.IAWayfindingRequest;
import com.indooratlas.android.sdk.resources.IAFloorPlan;
import com.indooratlas.android.sdk.resources.IALatLng;
import com.indooratlas.android.sdk.resources.IALocationListenerSupport;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class LocationActivity extends FragmentActivity implements GoogleMap.OnMapClickListener, OnMapReadyCallback {

    private static final int MY_PERMISSION_ACCESS_FINE_LOCATION = 42;

    private static final String TAG = "LocationActivity";

    /* used to decide when bitmap should be downscaled */
    private static final int MAX_DIMENSION = 2048;

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private Circle mCircle;
    private IARegion mOverlayFloorPlan = null;
    private GroundOverlay mGroundOverlay = null;
    private IALocationManager mIALocationManager;
    private Target mLoadTarget;
    private boolean mCameraPositionNeedsUpdating = true; // update on first location
    private Marker mDestinationMarker;
    private Marker mHeadingMarker;
    private List<Polyline> mPolylines = new ArrayList<>();
    private IARoute mCurrentRoute;

    private IAWayfindingRequest mWayfindingDestination;
    private IAWayfindingListener mWayfindingListener = new IAWayfindingListener() {
        @Override
        public void onWayfindingUpdate(IARoute route) {
            mCurrentRoute = route;
            if (hasArrivedToDestination(route)) {
                // stop wayfinding
                showInfo("You're there!");
                mCurrentRoute = null;
                mWayfindingDestination = null;
                mIALocationManager.removeWayfindingUpdates();
            }
            updateRouteVisualization();
        }
    };

    private IAOrientationListener mOrientationListener = new IAOrientationListener() {
        @Override
        public void onHeadingChanged(long timestamp, double heading) {
            updateHeading(heading);
        }

        @Override
        public void onOrientationChange(long timestamp, double[] quaternion) {
            // we do not need full device orientation in this example, just the heading
        }
    };

    private int mFloor;

    private void showLocationCircle(LatLng center, double accuracyRadius) {
        if (mCircle == null) {
            // location can received before map is initialized, ignoring those updates
            if (mMap != null) {
                mCircle = mMap.addCircle(new CircleOptions()
                        .center(center)
                        .radius(accuracyRadius)
                        .fillColor(0x201681FB)
                        .strokeColor(0x500A78DD)
                        .zIndex(1.0f)
                        .visible(true)
                        .strokeWidth(5.0f));
                mHeadingMarker = mMap.addMarker(new MarkerOptions()
                        .position(center)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_blue_dot))
                        .anchor(0.5f, 0.5f)
                        .flat(true));

                // Show zoom controls
                mMap.getUiSettings().setZoomControlsEnabled(true);
            }
        } else {
            // move existing markers position to received location
            mCircle.setCenter(center);
            mHeadingMarker.setPosition(center);
            mCircle.setRadius(accuracyRadius);
        }
    }

    private void updateHeading(double heading) {
        if (mHeadingMarker != null) {
            mHeadingMarker.setRotation((float) heading);
        }
    }

    /**
     * Listener that handles location change events.
     */
    private IALocationListener mListener = new IALocationListenerSupport() {

        /**
         * Location changed, move marker and camera position.
         */
        @Override
        public void onLocationChanged(IALocation location) {

            Log.d(TAG, "new location received with coordinates: " + location.getLatitude()
                    + "," + location.getLongitude());

            if (mMap == null) {
                // location received before map is initialized, ignoring update here
                return;
            }

            final LatLng center = new LatLng(location.getLatitude(), location.getLongitude());

            final int newFloor = location.getFloorLevel();
            if (mFloor != newFloor) {
                updateRouteVisualization();
            }
            mFloor = newFloor;

            showLocationCircle(center, location.getAccuracy());

            // our camera position needs updating if location has significantly changed
            if (mCameraPositionNeedsUpdating) {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 17.5f));
                mCameraPositionNeedsUpdating = false;
            }
        }
    };

    /**
     * Listener that changes overlay if needed
     */
    private IARegion.Listener mRegionListener = new IARegion.Listener() {
        @Override
        public void onEnterRegion(IARegion region) {
            if (region.getType() == IARegion.TYPE_FLOOR_PLAN) {
                Log.d(TAG, "enter floor plan " + region.getId());
                mCameraPositionNeedsUpdating = true; // entering new fp, need to move camera
                if (mGroundOverlay != null) {
                    mGroundOverlay.remove();
                    mGroundOverlay = null;
                }
                mOverlayFloorPlan = region; // overlay will be this (unless error in loading)
                fetchFloorPlanBitmap(region.getFloorPlan());
            }
        }

        @Override
        public void onExitRegion(IARegion region) { }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        // prevent the screen going to sleep while app is on foreground
        findViewById(android.R.id.content).setKeepScreenOn(true);

        // instantiate IALocationManager
        mIALocationManager = IALocationManager.create(this);

        // disable indoor-outdoor detection (assume we're indoors)
        mIALocationManager.lockIndoors(true);

        // Request GPS locations
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_ACCESS_FINE_LOCATION);
            return;
        }

        // Try to obtain the map from the SupportMapFragment.
        ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map))
                .getMapAsync(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_navigate:
                        openNavigateMe();
                        break;
                    case R.id.action_map:
                        openFloorPlan();
                        break;
                    case R.id.action_paths:
                        Toast.makeText(LocationActivity.this, "Nearby", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    public void openFloorPlan(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openNavigateMe(){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // remember to clean up after ourselves
        mIALocationManager.destroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // start receiving location updates & monitor region changes
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mListener);
        mIALocationManager.registerRegionListener(mRegionListener);
        mIALocationManager.registerOrientationListener(
                // update if heading changes by 1 degrees or more
                new IAOrientationRequest(1, 0),
                mOrientationListener);

        if (mWayfindingDestination != null) {
            mIALocationManager.requestWayfindingUpdates(mWayfindingDestination, mWayfindingListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // unregister location & region changes
        mIALocationManager.removeLocationUpdates(mListener);
        mIALocationManager.unregisterRegionListener(mRegionListener);
        mIALocationManager.unregisterOrientationListener(mOrientationListener);

        if (mWayfindingDestination != null) {
            mIALocationManager.removeWayfindingUpdates();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // do not show Google's outdoor location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(false);
        mMap.setOnMapClickListener(this);
    }

    /**
     * Sets bitmap of floor plan as ground overlay on Google Maps
     */
    private void setupGroundOverlay(IAFloorPlan floorPlan, Bitmap bitmap) {

        if (mGroundOverlay != null) {
            mGroundOverlay.remove();
        }

        if (mMap != null) {
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
            IALatLng iaLatLng = floorPlan.getCenter();
            LatLng center = new LatLng(iaLatLng.latitude, iaLatLng.longitude);
            GroundOverlayOptions fpOverlay = new GroundOverlayOptions()
                    .image(bitmapDescriptor)
                    .zIndex(0.0f)
                    .position(center, floorPlan.getWidthMeters(), floorPlan.getHeightMeters())
                    .bearing(floorPlan.getBearing());

            mGroundOverlay = mMap.addGroundOverlay(fpOverlay);
        }
    }

    /**
     * Download floor plan using Picasso library.
     */
    private void fetchFloorPlanBitmap(final IAFloorPlan floorPlan) {

        if (floorPlan == null) {
            Log.e(TAG, "null floor plan in fetchFloorPlanBitmap");
            return;
        }

        final String url = floorPlan.getUrl();
        Log.d(TAG, "loading floor plan bitmap from "+url);

        mLoadTarget = new Target() {

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Log.d(TAG, "onBitmap loaded with dimensions: " + bitmap.getWidth() + "x"
                        + bitmap.getHeight());
                if (mOverlayFloorPlan != null && floorPlan.getId().equals(mOverlayFloorPlan.getId())) {
                    Log.d(TAG, "showing overlay");
                    setupGroundOverlay(floorPlan, bitmap);
                }
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                showInfo("Failed to load bitmap");
                mOverlayFloorPlan = null;
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                // N/A
            }

        };

        RequestCreator request = Picasso.get().load(url);

        final int bitmapWidth = floorPlan.getBitmapWidth();
        final int bitmapHeight = floorPlan.getBitmapHeight();

        if (bitmapHeight > MAX_DIMENSION) {
            request.resize(0, MAX_DIMENSION);
        } else if (bitmapWidth > MAX_DIMENSION) {
            request.resize(MAX_DIMENSION, 0);
        }

        request.into(mLoadTarget);
    }

    private void showInfo(String text) {
        final Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), text,
                Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(R.string.button_close, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    @Override
    public void onMapClick(LatLng point) {
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if (mMap != null) {

            mWayfindingDestination = new IAWayfindingRequest.Builder()
                    .withFloor(mFloor)
                    .withLatitude(point.latitude)
                    .withLongitude(point.longitude)
                    .build();

            mIALocationManager.requestWayfindingUpdates(mWayfindingDestination, mWayfindingListener);

            if (mDestinationMarker == null) {
                mDestinationMarker = mMap.addMarker(new MarkerOptions()
                        .position(point)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            } else {
                mDestinationMarker.setPosition(point);
            }
            Log.d(TAG, "Set destination: (" + mWayfindingDestination.getLatitude() + ", " +
                    mWayfindingDestination.getLongitude() + "), floor=" +
                    mWayfindingDestination.getFloor());
        }
    }

    private boolean hasArrivedToDestination(IARoute route) {
        // empty routes are only returned when there is a problem, for example,
        // missing or disconnected routing graph
        if (route.getLegs().size() == 0) {
            return false;
        }

        final double FINISH_THRESHOLD_METERS = 8.0;
        double routeLength = 0;
        for (IARoute.Leg leg : route.getLegs()) routeLength += leg.getLength();
        return routeLength < FINISH_THRESHOLD_METERS;
    }

    /**
     * Clear the visualizations for the wayfinding paths
     */
    private void clearRouteVisualization() {
        for (Polyline pl : mPolylines) {
            pl.remove();
        }
        mPolylines.clear();
    }

    /**
     * Visualize the IndoorAtlas Wayfinding route on top of the Google Maps.
     */
    private void updateRouteVisualization() {

        clearRouteVisualization();

        if (mCurrentRoute == null) {
            return;
        }

        for (IARoute.Leg leg : mCurrentRoute.getLegs()) {

            if (leg.getEdgeIndex() == null) {
                // Legs without an edge index are, in practice, the last and first legs of the
                // route. They connect the destination or current location to the routing graph.
                // All other legs travel along the edges of the routing graph.

                // Omitting these "artificial edges" in visualization can improve the aesthetics
                // of the route. Alternatively, they could be visualized with dashed lines.
                continue;
            }

            PolylineOptions opt = new PolylineOptions();
            opt.add(new LatLng(leg.getBegin().getLatitude(), leg.getBegin().getLongitude()));
            opt.add(new LatLng(leg.getEnd().getLatitude(), leg.getEnd().getLongitude()));

            // Here wayfinding path in different floor than current location is visualized in
            // a semi-transparent color
            if (leg.getBegin().getFloor() == mFloor && leg.getEnd().getFloor() == mFloor) {
                opt.color(0xFF0000FF);
            } else {
                opt.color(0x300000FF);
            }

            mPolylines.add(mMap.addPolyline(opt));
        }
    }
}

