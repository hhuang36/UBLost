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
    public ActivityTestRule<DestinationActivity> destinationActivityTestRule = new ActivityTestRule(DestinationActivity.class);
    public ActivityTestRule<LocationActivity> locationActivityActivityTestRule = new ActivityTestRule<>(LocationActivity.class);

    public LocationActivity location = null;
    @Before
    public void setUp() throws Exception {
        location = locationActivityActivityTestRule.getActivity();
    }

    // test that the location activity appears on the screen
    @Test
    public void testLocationActivityNotNull(){
        assertNotNull(location);
    }

    // test that the list view appears on the screen
    @Test
    public void testListViewNotNull(){
        ListView listView = location.search_location;
        assertNotNull(listView);
    }

    @After
    public void tearDown() throws Exception {
        location = null;
    }
}