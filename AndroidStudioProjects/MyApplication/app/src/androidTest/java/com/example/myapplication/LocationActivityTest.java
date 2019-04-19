package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.*;

public class LocationActivityTest {

    @Rule
    public ActivityTestRule<DestinationActivity> destinationActivityTestRule = new ActivityTestRule(DestinationActivity.class);
    public ActivityTestRule<LocationActivity> locationActivityActivityTestRule = new ActivityTestRule<>(LocationActivity.class);

    public LocationActivity location = null;
    @Before
    public void setUp() throws Exception {
        location = locationActivityActivityTestRule.getActivity();
    }
    
    @After
    public void tearDown() throws Exception {
        location = null;
    }
}