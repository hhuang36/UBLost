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

    // test that the second option shows the text "Lockwood Library"
    @Test
    public void testBuildingOptionsStringArray2(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[1], destination.adapter.getItem(1));
    }

    // test that the second option shows the text "Norton Hall"
    @Test
    public void testBuildingOptionsStringArray3(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[2], destination.adapter.getItem(2));
    }

    @After
    public void tearDown() throws Exception {
        destination = null;
    }


}