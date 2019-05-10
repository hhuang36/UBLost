package com.example.myapplication;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SplashScreenTest {

    @Rule
    public ActivityTestRule<SplashScreen> mainActivityActivityTestRule = new ActivityTestRule(SplashScreen.class);

    public SplashScreen mActivity = null;

    @Before
    public void setUp() throws Exception{
        mActivity = mainActivityActivityTestRule.getActivity();
    }

    // test that the app leads to home page
    @Test
    public void testLaunch() {
        View view = mActivity.findViewById(R.id.SplashScreen);
        assertNotNull(view);
    }

    // tests that the splash screen intent is used when app runs
    @Test
    public void testSplashScreenIntentExists(){
        Intent home = mActivity.getIntent();
        assertNotNull(home);
    }

    // tests that the time the splash screen displays is correct
    @Test
    public void testSplashTime(){
        int time = mActivity.SPLASH_TIME_OUT;
        assertTrue(time == 4000);
    }


    @After
    public void tearDown() throws Exception{
        mActivity = null;
    }

}
