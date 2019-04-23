package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationActivityTest {

    @Rule
    private ActivityTestRule<DestinationActivity> destinationActivityTestRule = new ActivityTestRule(DestinationActivity.class);
    private ActivityTestRule<LocationActivity> locationActivityActivityTestRule = new ActivityTestRule<>(LocationActivity.class);

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

    @After
    public void tearDown() {
        location = null;
    }
}