package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.graphics.Paint;
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

public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> homeActivtyTestRule = new ActivityTestRule(HomeActivity.class);
    public ActivityTestRule<CapenFloorOptions> capenFloorOptionsActivityTestRule = new ActivityTestRule(CapenFloorOptions.class);
    public HomeActivity hActivity = null;
    public CapenFloorOptions cFo = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CapenFloorOptions.class.getName(), null, false);

    @Before
    public void setUp() throws Exception{
        hActivity = homeActivtyTestRule.getActivity();
        cFo = capenFloorOptionsActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfCapenFloorPageOpensFromButton(){
        onView(withId(R.id.CapenButton)).perform(click());
        Activity options = getInstrumentation().waitForMonitorWithTimeout(monitor, 10000);
        assertNotNull(options);
        options.finish();
    }

    @Test
    public void testListOfOptionsPopUp(){
        onView(withId(R.id.CapenButton)).perform(click());
        View view = cFo.findViewById(R.array.search_capen_floors);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception{
        hActivity = null;
    }
}