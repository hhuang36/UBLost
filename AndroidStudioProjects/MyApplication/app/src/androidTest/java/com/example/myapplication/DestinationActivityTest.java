package com.example.myapplication;

import android.graphics.Color;
import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestinationActivityTest {

    @Rule
    public ActivityTestRule<DestinationActivity> destinationActivityTestRule = new ActivityTestRule(DestinationActivity.class);

    DestinationActivity destination = null;
    @Before
    public void setUp() throws Exception {
        destination = destinationActivityTestRule.getActivity();
    }

    // test that the first option shows the text "Capen Library"
    @Test
    public void testBuildingOptionsStringArray1(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[0], destination.adapter.getItem(0));
    }

    // test that the second option shows the text "Lockwood Library"
    @Test
    public void testBuildingOptionsStringArray2(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[1], destination.adapter.getItem(1));
    }

    // test that the third option shows the text "Norton Hall"
    @Test
    public void testBuildingOptionsStringArray3(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[2], destination.adapter.getItem(2));
    }

    // test that the fourth option shows the text "Davis Hall"
    @Test
    public void testBuildingOptionsStringArray4(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[3], destination.adapter.getItem(3));
    }

    // test that the fifth option shows the text "Music Library"
    @Test
    public void testBuildingOptionsStringArray5(){
        String BuildingOptions[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library"};
        assertEquals(BuildingOptions[4], destination.adapter.getItem(4));
    }

    // test that the ListView appears on the screen when destination activity is run
    @Test
    public void testListViewExists(){
        ListView lv = destination.search_building;
        assertNotNull(lv);
    }

    // test that the list view used is the correct one from corresponding xml file using ID's
    @Test
    public void testListViewHasCorrectID(){
        ListView lv = destination.search_building;
        int lvID = lv.getId();
        int expectedID = R.id.search_building;
        assertEquals(lvID, expectedID);
    }

    // test that the TextView appears on the screen when destination activity is run
    @Test
    public void testTextViewExists(){
        TextView tv = destination.navigateMeTextView;
        assertNotNull(tv);
    }

    // test that the text view used is the correct one from corresponding xml file using ID's
    @Test
    public void testTextViewHasCorrectID(){
        TextView tv = destination.navigateMeTextView;
        int tvID = tv.getId();
        int expectedID = R.id.textView1;
        assertEquals(tvID, expectedID);
    }

    // test that the text view has the correct text shown, which should be "Navigate Me"
    @Test
    public void testTextViewHasCorrectText(){
        TextView tv = destination.navigateMeTextView;
        CharSequence text = tv.getText();
        CharSequence expectedText = "Navigate Me";
        assertEquals(text, expectedText);
    }

    // test that the text view has the correct text color shown, which should be white or -1 as an int
    @Test
    public void testTextColor(){
        TextView tv = destination.navigateMeTextView;
        int color = tv.getCurrentTextColor();
        int expected = -1; // -1 = FFFF = White
        assertEquals(expected, color);
    }

    // test that the search bar is displayed on the screen
    @Test
    public void testSearchViewExists(){
        SearchView searchView = destination.searchView;
        assertNotNull(searchView);
    }

    @After
    public void tearDown() throws Exception {
        destination = null;
    }



}