package com.example.myapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;
import org.w3c.dom.Text;

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

    // tests that the splash screen intent is used when app runs
    @Test
    public void testSplashScreenIntentExists(){
        Intent home = mActivity.getIntent();
        assertNotNull(home);
    }

    // tests that the splash screen displayed on the screen has the text "UB LOST"
    @Test
    public void testTextMatchesLogo() {
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        CharSequence logo = tv.getText();
        CharSequence actual = "UB LOST";
        assertTrue(logo.equals(actual));
    }

    // tests that the length of the text is correct
    @Test
    public void testTextLength(){
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        int wordLength = tv.getText().length();
        assertTrue(wordLength == 7);

    }

    // tests that the background is the right color
    @Test
    public void testTextViewColor(){
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        int color = tv.getCurrentTextColor();
        TextView tv2 = mActivity.tv;
        int color2 = tv2.getCurrentTextColor();
        assertTrue(color == color2);
    }

    // tests that the time the splash screen displays is correct
    @Test
    public void testSplashTime(){
        int time = mActivity.SPLASH_TIME_OUT;
        assertTrue(time == 4000);
    }

    // tests that the size of the text is the right size
    @Test
    public void testTextViewTextSize(){
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        float textSize = tv.getTextSize();
        TextView tv2 = mActivity.tv;
        float size = tv2.getTextSize();
        assertTrue(textSize == size);
    }

    @After
    public void tearDown() throws Exception{
        mActivity = null;
    }

}
