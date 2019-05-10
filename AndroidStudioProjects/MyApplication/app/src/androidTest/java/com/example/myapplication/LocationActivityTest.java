package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk.IARoute;
import com.squareup.picasso.Target;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LocationActivityTest {

    @Rule
    public ActivityTestRule<LocationActivity> locationActivityActivityTestRule = new ActivityTestRule<>(LocationActivity.class);

    public LocationActivity location = null;
    @Before
    public void setUp() {
        location = locationActivityActivityTestRule.getActivity();
    }

    // test that the location activity appears on the screen
    @Test
    public void testLocationActivityNotNull(){
        assertNotNull(location);
    }

    @Test
    public void testCameraUpdates(){
        boolean mCameraPositionNeedsUpdating = location.mCameraPositionNeedsUpdating;
        assertTrue(mCameraPositionNeedsUpdating);
    }

    @After
    public void tearDown() {
        location = null;
    }




}