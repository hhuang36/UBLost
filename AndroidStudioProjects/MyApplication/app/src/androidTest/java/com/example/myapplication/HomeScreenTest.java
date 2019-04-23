package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class HomeScreenTest {

    @Rule
    public ActivityTestRule<HomeScreen> splashScreenHomeRule = new ActivityTestRule(HomeScreen.class);

    private HomeScreen splashScreen = null;
    private Instrumentation.ActivityMonitor HomePage = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);
    private Instrumentation.ActivityMonitor NavigationOptions = getInstrumentation().addMonitor(DestinationActivity.class.getName(), null, false);

    @Before
    public void setUp() {
        splashScreen = splashScreenHomeRule.getActivity();
    }

    // tests that the Splash Screen Text is displayed when the application is run
    @Test
    public void testHomeScreenTextViewPopsUp(){
        View view = splashScreen.findViewById(R.id.textView);
        assertNotNull(view);
    }

    // tests that the Search Floor Plans button when clicked brings user to HomeActivity.java
    @Test
    public void testLaunchOfSearchFloorPlansButton(){
        onView(withId(R.id.action_map)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(HomePage, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    // tests that the Navigate Me Button is displayed on the screen
    @Test
    public void testFloorPlanButtonExists(){
        Button nmb = splashScreen.findViewById(R.id.action_map);
        assertNotNull(nmb);
    }

    // tests that the Floor Plan Button is displayed on the screen
    @Test
    public void testNavigateMeButtonExists(){
        Button fpb = splashScreen.findViewById(R.id.action_navigate);
        assertNotNull(fpb);

    }

    // tests that Navigate Me button when clicked brings user to DestinationActivity.java
    @Test
    public void testLaunchOfNavigateMe(){
        assertNotNull(splashScreen.findViewById(R.id.action_navigate));

        onView(withId(R.id.action_navigate)).perform(click());
        Activity thirdActivity = getInstrumentation().waitForMonitorWithTimeout(NavigationOptions, 5000);
        assertNotNull(thirdActivity);
        thirdActivity.finish();
    }

    // tests that the splash screen displayed on the screen has the text "Home Page"
    @Test
    public void testTextMatchesHomePageText() {
        TextView tv = splashScreen.findViewById(R.id.textView);
        CharSequence logo = tv.getText();
        CharSequence actual = "Home Page";
        assertEquals(logo, actual);
    }

    // tests that the length of the text is correct
    @Test
    public void testTextLength(){
        TextView tv = splashScreen.findViewById(R.id.textView);
        int wordLength = tv.getText().length();
        assertEquals(9, wordLength);

    }

    @After
    public void tearDown() {
        splashScreen = null;
    }
}