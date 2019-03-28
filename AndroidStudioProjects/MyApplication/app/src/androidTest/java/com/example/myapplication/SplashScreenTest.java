package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class SplashScreenTest {

    @Rule
    public ActivityTestRule<SplashScreen> splashScreenHomeRule = new ActivityTestRule(SplashScreen.class);

    public SplashScreen splashScreen = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(HomeActivity2.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        splashScreen = splashScreenHomeRule.getActivity();
    }

    @Test
    public void testHomeScreenPopsUp(){
        View view = splashScreen.findViewById(R.id.textView);
        assertNotNull(view);
    }

    @Test
    public void testLaunchOfSearchFloorPlansButton(){
        assertNotNull(splashScreen.findViewById(R.id.floorplanButton));

        onView(withId(R.id.floorplanButton)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testLaunchOfNavigateMe(){
        assertNotNull(splashScreen.findViewById(R.id.NavigateMe));

        onView(withId(R.id.NavigateMe)).perform(click());
        Activity thirdActivity = getInstrumentation().waitForMonitorWithTimeout(monitor2, 5000);
        assertNotNull(thirdActivity);
        thirdActivity.finish();
    }


    @After
    public void tearDown() throws Exception {
        splashScreen = null;
    }
}