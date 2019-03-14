package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule(MainActivity.class);

    public MainActivity mActivity = null;

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

    @After
    public void tearDown() throws Exception{
        mActivity = null;
    }

}

/***
 Button button = (Button) findViewById(R.id.my_button);
 Drawable buttonBackground = button.getBackground();
 and you can try like this

 ColorDrawable b_color = (ColorDrawable) button.getBackground();
 and then

 int color = b_color.getColor();
 if (color == R.color.green) {
 log("color is green");
 }
 ***/