package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.Adapter;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class CapenFloorOptionsTest {


    @Rule
    public ActivityTestRule<CapenFloorOptions> capenFloorOptionsActivityTestRule = new ActivityTestRule(CapenFloorOptions.class);

    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CapenFloor2Plan.class.getName(), null, false);
    private Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(CapenFloor3Plan.class.getName(), null, false);
    private Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(CapenFloor4Plan.class.getName(), null, false);

    private CapenFloorOptions cFO = null;

    @Before
    public void setUp() throws Exception{
        cFO = capenFloorOptionsActivityTestRule.getActivity();
    }

    // test that the first option shows the text "Floor2"
    @Test
    public void testCapenFloorStringArray1(){
        String[] FloorTexts = new String[]{"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[0], cFO.capenFloorButtons[0]);
    }

    // test that the first option shows the text "Floor3"
    @Test
    public void testCapenFloorStringArray2(){
        String[] FloorTexts = new String[]{"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[1], cFO.capenFloorButtons[1]);
    }

    // test that the first option shows the text "Floor4"
    @Test
    public void testCapenFloorStringArray3(){
        String[] FloorTexts = new String[]{"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[2], cFO.capenFloorButtons[2]);
    }

    // test that the list view on display is the intended list view from the corresponding xml file
    @Test
    public void testListViewAppears(){
        ListView lv = cFO.search_capen;
        assertNotNull(lv);
    }

    // test that the adapter in CapenFloorOptions.java is not null and appears on screen
    @Test
    public void testAdapterNotNull(){
        Adapter ad = cFO.adapter;
        assertNotNull(ad);
    }

    // tests that the ListView is using the right string array by testing the Id's
    @Test
    public void testListViewHasCorrectId(){
        ListView lv = cFO.search_capen;
        int id = lv.getId();
        assertEquals(id, R.id.search_capen_floors);
    }

    // test that the Floor 2 option brings the user to the CapenFloor2Plan.java activity
    @Test
    public void testFloorTwo(){
        final ListView lv = cFO.search_capen;
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                lv.performItemClick(lv.getAdapter().getView(0, null, null),
                        0, lv.getAdapter().getItemId(0));
            }
        });
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    // test that the Floor 3 option brings the user to the CapenFloor3Plan.java activity
    @Test
    public void testFloorThree(){
        final ListView lv = cFO.search_capen;
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                lv.performItemClick(lv.getAdapter().getView(1, null, null),
                        1, lv.getAdapter().getItemId(1));
            }
        });
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor1, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    // test that the Floor 3 option brings the user to the CapenFloor3Plan.java activity
    @Test
    public void testFloorFloor(){
        final ListView lv = cFO.search_capen;
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                lv.performItemClick(lv.getAdapter().getView(2, null, null),
                        2, lv.getAdapter().getItemId(2));
            }
        });
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor2, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }


    @After
    public void tearDown() {
        cFO = null;
    }

}