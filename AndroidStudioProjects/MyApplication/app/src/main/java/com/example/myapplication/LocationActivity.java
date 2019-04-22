package com.example.myapplication;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.SpannableString;
//import android.text.Spanned;
//import android.text.method.LinkMovementMethod;
//import android.text.style.ClickableSpan;
//import android.text.style.ForegroundColorSpan;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.SearchView;
//import android.widget.TextView;
//
//import com.indooratlas.android.sdk.IALocationManager;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class LocationActivity extends AppCompatActivity {
//
//    ListView search_location;
//    ArrayAdapter<String> adapter;
//    TextView locationTextView;
//    String locationButtons[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library", "Natural Science Complex", "Student Union", "Knox Hall"};
//    SearchView searchView;
//    TextView getCurrentLocation;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_location);
//
//        IALocationManager mIALocationManager = IALocationManager.create(this);
//
//        search_location = findViewById(R.id.search_location);
//
//        ArrayList<String> arrayLocations = new ArrayList<String>();
//        arrayLocations.addAll(Arrays.asList(getResources().getStringArray(R.array.my_locations)));
//
//        adapter = new ArrayAdapter<String>(
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                arrayLocations
//        );
//
//        search_location.setAdapter(adapter);
//
//        search_location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(locationButtons[position] == "Capen Library"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                } else if(locationButtons[position] == "Lockwood Library"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                } else if(locationButtons[position] == "Norton Hall"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                } else if(locationButtons[position] == "Davis Hall"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                } else if(locationButtons[position] == "Music Library"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                } else if(locationButtons[position] == "Natural Science Complex"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                } else if(locationButtons[position] == "Student Union"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                } else if(locationButtons[position] == "Knox Hall"){
//                    Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });
//
//        locationTextView = findViewById(R.id.locationTextView);
//        getCurrentLocation = findViewById(R.id.locateMeButton);
//
//        String text = "Find my location!";
//        SpannableString ss = new SpannableString(text);
//        ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark));
//
//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                Intent intent = new Intent(LocationActivity.this, DestinationActivity.class);
//                startActivity(intent);
//            }
//        };
//
//        ss.setSpan(clickableSpan, 0, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(color, 0, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        getCurrentLocation.setText(ss);
//        getCurrentLocation.setMovementMethod(LinkMovementMethod.getInstance());
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_location_menu, menu);
//        MenuItem item = menu.findItem(R.id.search_location);
//        searchView = (SearchView) item.getActionView();
//        searchView.setQueryHint("Search Location...");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//    }
//}


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IARegion;

import utils.ExampleUtils;

public class LocationActivity extends FragmentActivity implements IALocationListener, OnMapReadyCallback {

    private static final float HUE_IABLUE = 200.0f;

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Marker mMarker;
    private IALocationManager mIALocationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        mIALocationManager = IALocationManager.create(this);

        // Try to obtain the map from the SupportMapFragment.
        ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map))
                .getMapAsync(this);
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
        if (mIALocationManager != null) {
            mIALocationManager.removeLocationUpdates(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                ExampleUtils.shareText(LocationActivity.this, mIALocationManager.getExtraInfo().traceId,
                        "traceId");
            }
        });
//        LatLng capen = new LatLng(43.00871, -78.789565);
//        mMap.addMarker(new MarkerOptions().position(capen).title("Capen"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(capen));
    }

    /**
     * Callback for receiving locations.
     * This is where location updates can be handled by moving markers or the camera.
     */
    public void onLocationChanged(IALocation location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (mMarker == null) {
            if (mMap != null) {
                mMarker = mMap.addMarker(new MarkerOptions().position(latLng)
                        .icon(BitmapDescriptorFactory.defaultMarker(HUE_IABLUE)));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));
            }
        } else {
            mMarker.setPosition(latLng);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // N/A
    }
}

