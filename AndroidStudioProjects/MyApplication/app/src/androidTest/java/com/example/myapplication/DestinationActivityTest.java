package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestinationActivityTest {

    @Rule
    public ActivityTestRule<DestinationActivity> destinationActivityTestRule = new ActivityTestRule(DestinationActivity.class);

    DestinationActivity destination = null;
    @Before
    public void setUp() throws Exception {
        destination = destinationActivityTestRule.getActivity();
    }

    // test that the first option shows the text "Capen Library"
    @Test
    public void testBuildingOptionsStringArray1(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[0], destination.adapter.getItem(0));
    }

    @After
    public void tearDown() throws Exception {
        destination = null;
    }


}