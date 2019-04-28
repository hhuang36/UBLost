package com.example.myapplication;

import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;

import utils.ExampleUtils;

public class HomeScreen extends FragmentActivity implements IALocationListener, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, OnMapReadyCallback { // THIS IS THE HOME PAGE

    private static final String TAG = "HomeScreen";
    private ActionBarDrawerToggle menuToggle;

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Circle mCircle;
    private Marker mHeadingMarker;
    private boolean mCameraPositionNeedsUpdating = true; // update on first location
    private IALocationManager mIALocationManager;

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;
    private FirebaseAuth mAuth;

    //activity attributes
    ImageView profileAvatar;
    TextView profileName;
    TextView profileStatus;

    ListView profile_options;
    ArrayAdapter<String> adapter;
    String[] profileOptions = new String[]{"Messages", "My Paths", "My Account"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
                        openSavedFloorPlans();
                        break;
                    case R.id.user_profile:
                        openUserProfile();
                        break;
                }
                return true;
            }
        });

        profile_options = findViewById(R.id.profile_options_list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, profileOptions);
        profile_options.setAdapter(adapter);
        profile_options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(profileOptions[position].equals("Messages")){
                    Intent intent = new Intent(HomeScreen.this, MessagesActivity.class);
                    startActivity(intent);
                } else if(profileOptions[position].equals("My Paths")){
                    Intent intent = new Intent(HomeScreen.this, PubPathsActivity.class);
                    startActivity(intent);
                } else if(profileOptions[position].equals("My Account")){
                    Intent intent = new Intent(HomeScreen.this, SettingsActivity.class);
                    startActivity(intent);
                }
            }
        });

        //database
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        //activity attributes
        profileAvatar = findViewById(R.id.profileAvatar);
        profileName = findViewById(R.id.profileName);
        String name = mAuth.getCurrentUser().getEmail();
        name = name.replace("@buffalo.edu","");
        profileName.setText(name);
        profileStatus = findViewById(R.id.profileStatus);
        String status = mAuth.getCurrentUser().getUid();


//        DrawerLayout menuDrawerLayout = findViewById(R.id.drawerLayout);
//        menuToggle = new ActionBarDrawerToggle(this, menuDrawerLayout, R.string.open, R.string.close);
//
//        menuDrawerLayout.addDrawerListener(menuToggle);
//        menuToggle.syncState();

        mIALocationManager = IALocationManager.create(this);

        // Try to obtain the map from the SupportMapFragment.
//        ((SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map))
//                .getMapAsync(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIALocationManager.destroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (mIALocationManager != null) {
//            mIALocationManager.removeLocationUpdates(this);
//        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
//            @Override
//            public void onMapLongClick(LatLng latLng) {
//                ExampleUtils.shareText(HomeScreen.this, mIALocationManager.getExtraInfo().traceId,
//                        "traceId");
//            }
//        });
    }

//    private void showLocationCircle(LatLng center, double accuracyRadius) {
//        if (mCircle == null) {
//            // location can received before map is initialized, ignoring those updates
//            if (mMap != null) {
//                // enable the myLocation layer
//                mMap.setMyLocationEnabled(true);

//                mCircle = mMap.addCircle(new CircleOptions()
//                        .center(center)
//                        .radius(accuracyRadius)
//                        .fillColor(0x201681FB)
//                        .strokeColor(0x500A78DD)
//                        .zIndex(1.0f)
//                        .visible(true)
//                        .strokeWidth(5.0f));
//                mHeadingMarker = mMap.addMarker(new MarkerOptions()
//                        .position(center)
//                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_blue_dot))
//                        .anchor(0.5f, 0.5f)
//                        .flat(true));
//            }
//        } else {
////            // move existing markers position to received location
////            mCircle.setCenter(center);
////            mHeadingMarker.setPosition(center);
////            mCircle.setRadius(accuracyRadius);
//        }
//    }

    /**
     * Callback for receiving locations.
     * This is where location updates can be handled by moving markers or the camera.
     */
    public void onLocationChanged(IALocation location) {
//        Log.d(TAG, "new location received with coordinates: " + location.getLatitude()
//                + "," + location.getLongitude());
//
//        if (mMap == null) {
//            // location received before map is initialized, ignoring update here
//            return;
//        }
//
//        final LatLng center = new LatLng(location.getLatitude(), location.getLongitude());
//
//        showLocationCircle(center, location.getAccuracy());
//
//        // our camera position needs updating if location has significantly changed
//        if (mCameraPositionNeedsUpdating) {
//            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 17.5f));
//            mCameraPositionNeedsUpdating = false;
//        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    public void openFloorPlan(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openNavigateMe(){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    public void openSavedFloorPlans(){
        Intent intent = new Intent(this, SavedPaths.class);
        startActivity(intent);
    }

    public void openUserProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem x){
        if(menuToggle.onOptionsItemSelected(x)) {
            return true;
        }
        return super.onOptionsItemSelected(x);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }
}


