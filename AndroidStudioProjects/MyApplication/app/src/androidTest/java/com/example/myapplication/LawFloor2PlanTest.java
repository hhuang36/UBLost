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

public class LawFloor2PlanTest {
    @Rule
    public ActivityTestRule<LawFloor2Plan> lawFloor2PlanActivityTestRule = new ActivityTestRule<>(LawFloor2Plan.class);
    public ActivityTestRule<LawFloor3Plan> lawFloor3PlanActivityTestRule = new ActivityTestRule<>(LawFloor3Plan.class);
    public ActivityTestRule<LawFloor4Plan> lawFloor4PlanActivityTestRule = new ActivityTestRule<>(LawFloor4Plan.class);
    public ActivityTestRule<LawFloor5Plan> lawFloor5PlanActivityTestRule = new ActivityTestRule<>(LawFloor5Plan.class);
    public ActivityTestRule<LawFloor6Plan> lawFloor6PlanActivityTestRule = new ActivityTestRule<>(LawFloor6Plan.class);
    public ActivityTestRule<LawFloor7Plan> lawFloor7PlanActivityTestRule = new ActivityTestRule<>(LawFloor7Plan.class);

    LawFloor2Plan lF2P = null;
    LawFloor3Plan lF3P = null;
    LawFloor4Plan lF4P = null;
    LawFloor5Plan lF5P = null;
    LawFloor6Plan lF6P = null;
    LawFloor7Plan lF7P = null;

    @Before
    public void setUp() {
        lF2P = lawFloor2PlanActivityTestRule .getActivity();
        lF3P = lawFloor3PlanActivityTestRule .getActivity();
        lF4P = lawFloor4PlanActivityTestRule .getActivity();
        lF5P = lawFloor5PlanActivityTestRule .getActivity();
        lF6P = lawFloor6PlanActivityTestRule .getActivity();
        lF7P = lawFloor7PlanActivityTestRule .getActivity();
    }

    @Test
    public void testLawFloor2(){
        ImageAdapter imageAdapter = lF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.law_2;
        assertEquals(secondFloor, expected);
    }

    @Test
    public void setLawFloor3(){
        ImageAdapter imageAdapter = lF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.law_3;
        assertEquals(secondFloor, expected);
    }

    @Test
    public void setLawFloor4(){
        ImageAdapter imageAdapter = lF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.law_4;
        assertEquals(secondFloor, expected);
    }
    @Test
    public void setLawFloor5(){
        ImageAdapter imageAdapter = lF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.law_5;
        assertEquals(secondFloor, expected);
    }
    @Test
    public void setLawFloor6(){
        ImageAdapter imageAdapter = lF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.law_6;
        assertEquals(secondFloor, expected);
    }
    @Test
    public void setLawFloor7(){
        ImageAdapter imageAdapter = lF2P.adapter;
        java.lang.Object secondFloor = imageAdapter.getmImageIds().get(0);
        java.lang.Object expected = R.mipmap.law_7;
        assertEquals(secondFloor, expected);
    }


    @After
    public void tearDown() {
        lF2P = null;
        lF3P = null;
        lF4P = null;
        lF5P = null;
        lF6P = null;
        lF7P = null;
    }

}