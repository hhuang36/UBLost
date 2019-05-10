package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CapenFloor2PlanTest {
    @Rule
    public ActivityTestRule<CapenFloor2Plan> capenFloor2PlanActivityTestRule = new ActivityTestRule<>(CapenFloor2Plan.class);
    public ActivityTestRule<CapenFloor3Plan> capenFloor3PlanActivityTestRule = new ActivityTestRule<>(CapenFloor3Plan.class);
    public ActivityTestRule<CapenFloor4Plan> capenFloor4PlanActivityTestRule = new ActivityTestRule<>(CapenFloor4Plan.class);

    CapenFloor2Plan cF2P = null;
    CapenFloor3Plan cF3P = null;
    CapenFloor4Plan cF4P = null;

    @Before
    public void setUp() {
        cF2P = capenFloor2PlanActivityTestRule.getActivity();
        cF3P = capenFloor3PlanActivityTestRule.getActivity();
        cF4P = capenFloor4PlanActivityTestRule.getActivity();
    }

    @Test
    public void testCapenFloor2(){
        ImageAdapter imageAdapter = cF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.capen_floor_2;
        assertEquals(secondFloor, expected);
    }

    @Test
    public void testCapenFloor3(){
        ImageAdapter imageAdapter = cF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(1);
        java.lang.Object expected = R.mipmap.capen_floor_3;
        assertEquals(secondFloor, expected);
    }

    @Test
    public void testCapenFloor4(){
        ImageAdapter imageAdapter = cF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(2);
        java.lang.Object expected = R.mipmap.capen_floor_4;
        assertEquals(secondFloor, expected);
    }

    @After
    public void tearDown() {
        cF2P = null;
        cF3P = null;
        cF4P = null;
    }

}
