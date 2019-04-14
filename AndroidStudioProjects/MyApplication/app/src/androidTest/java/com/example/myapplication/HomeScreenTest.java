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

    public HomeScreen splashScreen = null;
    Instrumentation.ActivityMonitor HomePage = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor NavigationOptions = getInstrumentation().addMonitor(DestinationActivity.class.getName(), null, false);

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

    // tests that the Search Floor Plans button when clicked brings user to HomeActivity.java
    @Test
    public void testLaunchOfSearchFloorPlansButton(){
        onView(withId(R.id.floorplanButton)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(HomePage, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    // tests that the Navigate Me Button is displayed on the screen
    @Test
    public void testFloorPlanButtonExists(){
        Button nmb = splashScreen.findViewById(R.id.NavigateMe);
        assertNotNull(nmb);
    }

    // tests that the Floor Plan Button is displayed on the screen
    @Test
    public void testNavigateMeButtonExists(){
        Button fpb = splashScreen.findViewById(R.id.floorplanButton);
        assertNotNull(fpb);

    }

    // tests that Navigate Me button when clicked brings user to DestinationActivity.java
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


    // tests that the text on the Floor Plan button displays "Search Floor Plans"
    @Test
    public void FloorPlanButtonText(){
        Button button = splashScreen.floorplanButton;
        CharSequence buttonText = button.getText();
        CharSequence expected = "Search Floor Plans";
        assertEquals(buttonText, expected);
    }

    // tests that the text on the Navigate Me button displays "Navigate Me"
    @Test
    public void NavigateMeButtonText(){
        Button button = splashScreen.navigateMe;
        CharSequence buttonText = button.getText();
        CharSequence expected = "Navigate Me";
        assertEquals(buttonText, expected);
    }

    @After
    public void tearDown() throws Exception {
        splashScreen = null;
    }
}