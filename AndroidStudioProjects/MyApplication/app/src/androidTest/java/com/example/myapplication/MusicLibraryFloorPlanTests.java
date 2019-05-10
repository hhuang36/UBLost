package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MusicLibraryFloorPlanTests {
    @Rule
    public ActivityTestRule<MusicFloor1Plan> musicFloor1PlanActivityTestRule = new ActivityTestRule<>(MusicFloor1Plan.class);

    MusicFloor1Plan musicFloor1Plan = null;

    // setting up the activities to be tested
    @Before
    public void setUp() throws Exception {
        musicFloor1Plan = musicFloor1PlanActivityTestRule.getActivity();
    }

    // test that Music Floor 1 Plan activity, when clicked, displays the right image
    @Test
    public void testMusicFloor1(){
        ImageAdapter imageAdapter = musicFloor1Plan.adapter;
        java.lang.Object musicFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.music_1;
        assertEquals(musicFloor, expected);
    }

    // cleaning up after testing is done
    @After
    public void tearDown() throws Exception {
        musicFloor1Plan = null;
    }
}