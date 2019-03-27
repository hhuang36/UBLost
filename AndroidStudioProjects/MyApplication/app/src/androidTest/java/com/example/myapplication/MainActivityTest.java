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

    @Test
    public void testTextMatchesLogo() {
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        CharSequence logo = tv.getText();
        CharSequence actual = "UB LOST";
        assertTrue(logo.equals(actual));
    }

    @Test
    public void testTextLength(){
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        int wordLength = tv.getText().length();
        assertTrue(wordLength == 7);

    }

    @Test
    public void testTextViewTextSize(){ // need to fix
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        float textSize = tv.getTextSize();
        float size = 40;
        assertTrue(textSize == size);
    }

    @Test
    public void testTextViewColor(){
        TextView tv = mActivity.findViewById(R.id.SplashScreen);
        int color = tv.getCurrentTextColor();
        assertTrue(color == R.color.colorText);
    }

    @Test
    public void testSplashTime(){
        int time = mActivity.SPLASH_TIME_OUT;
        assertTrue(time == 4000);
    }

    @Test
    public void testSplashScreenIntentExists(){
        Intent home = mActivity.getIntent();
        assertNotNull(home);
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