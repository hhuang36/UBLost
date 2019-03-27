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
    public void testCapenButtonExists(){
        Button capenButton = hActivity.findViewById(R.id.MusicButton);
        assertNotNull(capenButton);
    }

    @Test
    public void testMusicButtonExists(){
        Button musicButton = hActivity.findViewById(R.id.MusicButton);
        assertNotNull(musicButton);
    }

    @Test
    public void testLockwoodButtonExists(){
        Button lockwoodButton = hActivity.findViewById(R.id.MusicButton);
        assertNotNull(lockwoodButton);
    }

    @Test
    public void testCapenButtonHasBackground(){
        Button button = hActivity.findViewById(R.id.CapenButton);
        Drawable buttonBackground= button.getBackground();
        assertNotNull(buttonBackground);

    }

    @Test
    public void testCapenButtonText(){
        Button button = hActivity.findViewById(R.id.CapenButton);
        CharSequence text = button.getText();
        CharSequence actual = "Capen Library";
        assertEquals(text, actual);

    }

    @Test
    public void testMusicButtonText(){
        Button button = hActivity.findViewById(R.id.MusicButton);
        CharSequence text = button.getText();
        CharSequence actual = "Music Library";
        assertEquals(text, actual);

    }

    @Test
    public void testTextViewText(){
        TextView tv = hActivity.findViewById(R.id.textView1);
        CharSequence logo = tv.getText();
        CharSequence actual = "Search Floor Plans";
        assertEquals(logo, actual);
    }

    @Test
    public void testLockwoodButtonText(){
        Button button = hActivity.findViewById(R.id.LockWoodButton);
        CharSequence text = button.getText();
        CharSequence actual = "Lockwood Library";
        assertEquals(text, actual);

    }

    @Test
    public void testMusicButtonHasBackground(){
        Button button = hActivity.findViewById(R.id.MusicButton);
        Drawable buttonBackground= button.getBackground();
        assertNotNull(buttonBackground);

    }
    @Test
    public void testLockwoodButtonHasBackground(){
        Button button = hActivity.findViewById(R.id.LockWoodButton);
        Drawable buttonBackground= button.getBackground();
        assertNotNull(buttonBackground);

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