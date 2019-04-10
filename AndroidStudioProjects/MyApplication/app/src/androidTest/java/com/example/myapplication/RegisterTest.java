package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class RegisterTest {

    Instrumentation.ActivityMonitor homePage = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
    }

    // tests that when the uer is done filling out his or her credentials and clicks the register button, the home page should be displayed.
    @Test
    public void testRegisterLeadsToHomePage(){
        onView(withId(R.id.registerButton)).perform(click());
        Activity homeActivity = getInstrumentation().waitForMonitorWithTimeout(homePage, 5000);
        assertNotNull(homeActivity);
        homeActivity.finish();

    }

    @After
    public void tearDown() throws Exception {
    }
}