package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.annotation.FloatRange;
import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class CapenFloorOptionsTest {


    @Rule
    public ActivityTestRule<CapenFloorOptions> capenFloorOptionsActivityTestRule = new ActivityTestRule(CapenFloorOptions.class);

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CapenFloor1Plan.class.getName(), null, false);

    public CapenFloorOptions cFO = null;

    @Before
    public void setUp() throws Exception{
        cFO = capenFloorOptionsActivityTestRule.getActivity();
    }

    // test that the first option shows the text "Floor2"
    @Test
    public void testCapenFloorStringArray1(){
        String FloorTexts[] = new String [] {"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[0], cFO.capenFloorButtons[0]);
    }

    // test that the first option shows the text "Floor3"
    @Test
    public void testCapenFloorStringArray2(){
        String FloorTexts[] = new String [] {"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[1], cFO.capenFloorButtons[1]);
    }

    // test that the first option shows the text "Floor4"
    @Test
    public void testCapenFloorStringArray3(){
        String FloorTexts[] = new String [] {"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[2], cFO.capenFloorButtons[2]);
    }

    // test that the list view on display is the intended list view from the corresponding xml file
    @Test
    public void testListViewAppears(){
        ListView lv = cFO.search_capen;
        int id = lv.getId();
        assertEquals(id, R.id.search_capen_floors);
    }
    

    @Test
    public void testFloorTwo(){
        onView(withId(R.id.search_capen_floors)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testFloorThree(){

    }
    @Test
    public void testFloorFloor(){

    }
    @After
    public void tearDown() throws Exception{
        cFO = null;
    }

}