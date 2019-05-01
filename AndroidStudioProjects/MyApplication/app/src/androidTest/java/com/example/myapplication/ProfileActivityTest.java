package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.design.widget.BottomNavigationView;
import android.support.test.rule.ActivityTestRule;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.w3c.dom.Text;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class ProfileActivityTest {
    @Rule
    public ActivityTestRule<ProfileActivity> profileActivityActivityTestRule = new ActivityTestRule<ProfileActivity>(ProfileActivity.class);

    ProfileActivity profileActivity = null;
    private Instrumentation.ActivityMonitor monitor0 = getInstrumentation().addMonitor(MessagesActivity.class.getName(), null, false);
    private Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(PubPathsActivity.class.getName(), null, false);
    private Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(SettingsActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        profileActivity = profileActivityActivityTestRule.getActivity();
    }

    @Test
    public void testActivityNotNull(){
        assertNotNull(profileActivity);
    }

    @Test
    public void testProfileAvatarImageViewExists(){
        ImageView avatar = profileActivity.profileAvatar;
        assertNotNull(avatar);
    }

    @Test
    public void testProfileAvatarImageViewHasCorrectID(){
        ImageView avatar = profileActivity.profileAvatar;
        int ID = avatar.getId();
        int expectedID = R.id.profileAvatar;
        assertEquals(ID, expectedID);
    }

    @Test
    public void testProfileNameTextViewExists(){
        TextView profileName = profileActivity.profileName;
        assertNotNull(profileName);
    }

    @Test
    public void testProfileNameTextViewHasCorrectID(){
        TextView profileName = profileActivity.profileName;
        int ID = profileName.getId();
        int expectedID = R.id.profileName;
        assertEquals(ID, expectedID);
    }


    @Test
    public void testProfileStatusTextViewExists(){
        TextView profileStatus = profileActivity.profileStatus;
        assertNotNull(profileStatus);
    }

    @Test
    public void testProfileStatusTextViewHasCorrectID(){
        TextView profileStatus = profileActivity.profileStatus;
        int ID = profileStatus.getId();
        int expectedID = R.id.profileStatus;
        assertEquals(ID, expectedID);
    }

    @Test
    public void testListViewExists(){
        ListView profileOptions = profileActivity.profile_options;
        assertNotNull(profileOptions);
    }

    @Test
    public void testListViewHasCorrectID(){
        ListView profileOptions = profileActivity.profile_options;
        int ID = profileOptions.getId();
        int expectedID = R.id.profile_options_list;
        assertEquals(ID, expectedID);
    }

    @Test
    public void testAdapterExists(){
        Adapter adapter = profileActivity.adapter;
        assertNotNull(adapter);
    }

    @Test
    public void testProfileOptionsArray1(){
        String[] profileOptions = new String[]{"Messages", "My Paths", "My Account"};
        assertEquals(profileOptions[0], profileActivity.profileOptions[0]);
    }

    @Test
    public void testProfileOptionsArray2(){
        String[] profileOptions = new String[]{"Messages", "My Paths", "My Account"};
        assertEquals(profileOptions[1], profileActivity.profileOptions[1]);
    }

    @Test
    public void testProfileOptionsArray3(){
        String[] profileOptions = new String[]{"Messages", "My Paths", "My Account"};
        assertEquals(profileOptions[2], profileActivity.profileOptions[2]);
    }

    @Test
    public void testMessagesOption(){
        final ListView lv = profileActivity.profile_options;
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                lv.performItemClick(lv.getAdapter().getView(0, null, null),
                        0, lv.getAdapter().getItemId(0));
            }
        });

        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor0, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testMyPathsOption(){
        final ListView lv = profileActivity.profile_options;
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

    @Test
    public void testMyAccountOption(){
        final ListView lv = profileActivity.profile_options;
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

    @Test
    public void testBottomMenuBarExists(){
        BottomNavigationView bottomNavigationView = profileActivity.bottomNavigationView;
        assertNotNull(bottomNavigationView);
    }

    @Test
    public void testBottomMenuBarHasCorrectID(){
        BottomNavigationView bottomNavigationView = profileActivity.bottomNavigationView;
        int ID = bottomNavigationView.getId();
        int expectedID = R.id.bottom_navigation;
        assertEquals(ID, expectedID);
    }

    @After
    public void tearDown() throws Exception {
        profileActivity = null;
    }
}