package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
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

public class SplashScreenTest {

    @Rule
    public ActivityTestRule<SplashScreen> splashScreenHomeRule = new ActivityTestRule(SplashScreen.class);

    public SplashScreen splashScreen = null;
    Instrumentation.ActivityMonitor HomePage = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor NavigationOptions = getInstrumentation().addMonitor(HomeActivity2.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        splashScreen = splashScreenHomeRule.getActivity();
    }

    // tests that the Splash Screen Text is displayed when the application is run
    @Test
    public void testHomeScreenTextViewPopsUp(){
        View view = splashScreen.findViewById(R.id.textView);
        assertNotNull(view);
    }

    // tests that the Search Floor Plans Button is displayed on the screen
    @Test
    public void testLaunchOfSearchFloorPlansButton(){
        assertNotNull(splashScreen.findViewById(R.id.floorplanButton));
        onView(withId(R.id.floorplanButton)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(HomePage, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    // tests that the Navigate Me Button is displayed on the screen
    @Test
    public void testLaunchOfNavigateMe(){
        assertNotNull(splashScreen.findViewById(R.id.NavigateMe));

        onView(withId(R.id.NavigateMe)).perform(click());
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
        assertTrue(logo.equals(actual));
    }

    // tests that the length of the text is correct
    @Test
    public void testTextLength(){
        TextView tv = splashScreen.findViewById(R.id.textView);
        int wordLength = tv.getText().length();
        assertTrue(wordLength == 9);

    }

    // tests that the text view background is the right color
    @Test
    public void testTextViewColor(){
        TextView tv = splashScreen.findViewById(R.id.textView);
        int color = tv.getCurrentTextColor();
        TextView tv2 = splashScreen.tv;
        int color2 = tv2.getCurrentTextColor();
        assertTrue(color == color2);
    }

    @After
    public void tearDown() throws Exception {
        splashScreen = null;
    }
}