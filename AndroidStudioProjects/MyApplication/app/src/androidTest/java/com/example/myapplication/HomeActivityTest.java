package com.example.myapplication;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import android.app.Activity;
import android.app.Instrumentation;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class HomeActivityTest {

//    @Rule
//    public ActivityTestRule<HomeActivity> homeActivtyTestRule = new ActivityTestRule(HomeActivity.class);
//    public ActivityTestRule<CapenFloorOptions> capenFloorOptionsActivityTestRule = new ActivityTestRule(CapenFloorOptions.class);
//    public HomeActivity hActivity = null;
//    public CapenFloorOptions cFo = null;
//    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CapenFloorOptions.class.getName(), null, false);
//
//    @Before
//    public void setUp() throws Exception{
//        hActivity = homeActivtyTestRule.getActivity();
//        cFo = capenFloorOptionsActivityTestRule.getActivity();
//    }
//
//    // tests that CapenFloorOptions launches when Capen Library is clicked
//    @Test
//    public void testLaunchOfCapenFloorPageOpensFromButton(){
//        onView(withId(R.id.capenCard)).perform(click());
//        Activity options = getInstrumentation().waitForMonitorWithTimeout(monitor, 10000);
//        assertNotNull(options);
//        options.finish();
//    }
//
//    // tests that the Capen Library button is displayed
//    @Test
//    public void testCapenButtonExists(){
//        Button capenButton = hActivity.findViewById(R.id.CapenButton);
//        assertNotNull(capenButton);
//    }
//
//    // tests that the Music Library button is displayed
//    @Test
//    public void testMusicButtonExists(){
//        Button musicButton = hActivity.findViewById(R.id.MusicButton);
//        assertNotNull(musicButton);
//    }
//
//    // tests that the LockWood Library button is displayed
//    @Test
//    public void testLockwoodButtonExists(){
//        Button lockwoodButton = hActivity.findViewById(R.id.LockWoodButton);
//        assertNotNull(lockwoodButton);
//    }
//
//    // tests that the Capen Library button background is displayed
//    @Test
//    public void testCapenButtonHasBackground(){
//        Button button = hActivity.findViewById(R.id.CapenButton);
//        Drawable buttonBackground= button.getBackground();
//        assertNotNull(buttonBackground);
//
//    }
//
//    // tests that the Capen Library button text is correct
//    @Test
//    public void testCapenButtonText(){
//        Button button = hActivity.findViewById(R.id.CapenButton);
//        CharSequence text = button.getText();
//        CharSequence actual = "Capen Library";
//        assertEquals(text, actual);
//
//    }
//
//    // tests that the Music Library button text is correct
//    @Test
//    public void testMusicButtonText(){
//        Button button = hActivity.findViewById(R.id.MusicButton);
//        CharSequence text = button.getText();
//        CharSequence actual = "Music Library";
//        assertEquals(text, actual);
//
//    }
//
//    // tests that the "Search Floor Plans" text displayed is correct
//    @Test
//    public void testTextViewText(){
//        TextView tv = hActivity.findViewById(R.id.textView1);
//        CharSequence logo = tv.getText();
//        CharSequence actual = "Search Floor Plans";
//        assertEquals(logo, actual);
//    }
//
//    // tests that the LockWood Library button text is correct
//    @Test
//    public void testLockwoodButtonText(){
//        Button button = hActivity.findViewById(R.id.LockWoodButton);
//        CharSequence text = button.getText();
//        CharSequence actual = "Lockwood Library";
//        assertEquals(text, actual);
//
//    }
//
//    // tests that the Music Library button background is displayed
//    @Test
//    public void testMusicButtonHasBackground(){
//        Button button = hActivity.findViewById(R.id.MusicButton);
//        Drawable buttonBackground= button.getBackground();
//        assertNotNull(buttonBackground);
//
//    }
//
//    // tests that the Lockwood Library button background is displayed
//    @Test
//    public void testLockwoodButtonHasBackground(){
//        Button button = hActivity.findViewById(R.id.LockWoodButton);
//        Drawable buttonBackground= button.getBackground();
//        assertNotNull(buttonBackground);
//
//    }
//
//    // tests that the listview of options is displayed when the Capen Library button is clicked
//    @Test
//    public void testListOfOptionsPopUp(){
//        onView(withId(R.id.CapenButton)).perform(click());
//        Activity options = getInstrumentation().waitForMonitorWithTimeout(monitor, 10000);
//        View list = options.findViewById(R.id.search_capen_floors);
//        assertNotNull(list);
//    }
//
//    @After
//    public void tearDown() throws Exception{
//        hActivity = null;
//        cFo = null;
//    }
}