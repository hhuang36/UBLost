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

    // initializing the activity
    @Before
    public void setUp() throws Exception {
        profileActivity = profileActivityActivityTestRule.getActivity();
    }

    // tests that the activity is not null when the application is run
    @Test
    public void testActivityNotNull(){
        assertNotNull(profileActivity);
    }

    // tests that the image view for the user profile exists
    @Test
    public void testProfileAvatarImageViewExists(){
        ImageView avatar = profileActivity.profileAvatar;
        assertNotNull(avatar);
    }

    // tests that the correct image view is used for the profile avatar
    @Test
    public void testProfileAvatarImageViewHasCorrectID(){
        ImageView avatar = profileActivity.profileAvatar;
        int ID = avatar.getId();
        int expectedID = R.id.profileAvatar;
        assertEquals(ID, expectedID);
    }

    // tests that the text view for the profile name exists
    @Test
    public void testProfileNameTextViewExists(){
        TextView profileName = profileActivity.profileName;
        assertNotNull(profileName);
    }

    // tests that the correct text view is used for the profile name
    @Test
    public void testProfileNameTextViewHasCorrectID(){
        TextView profileName = profileActivity.profileName;
        int ID = profileName.getId();
        int expectedID = R.id.profileName;
        assertEquals(ID, expectedID);
    }

    // tests that the text view for the profile status exists
    @Test
    public void testProfileStatusTextViewExists(){
        TextView profileStatus = profileActivity.profileStatus;
        assertNotNull(profileStatus);
    }

    // tests that the correct text view is used for the profile status
    @Test
    public void testProfileStatusTextViewHasCorrectID(){
        TextView profileStatus = profileActivity.profileStatus;
        int ID = profileStatus.getId();
        int expectedID = R.id.profileStatus;
        assertEquals(ID, expectedID);
    }

    // tests that the list view for the profile options exists
    @Test
    public void testListViewExists(){
        ListView profileOptions = profileActivity.profile_options;
        assertNotNull(profileOptions);
    }

    // tests that the correct list view is used for the profile options
    @Test
    public void testListViewHasCorrectID(){
        ListView profileOptions = profileActivity.profile_options;
        int ID = profileOptions.getId();
        int expectedID = R.id.profile_options_list;
        assertEquals(ID, expectedID);
    }

    // tests that the adapter for the profile options list view exists
    @Test
    public void testAdapterExists(){
        Adapter adapter = profileActivity.adapter;
        assertNotNull(adapter);
    }

    // tests that the first option in the list view displays exactly "Messages"
    @Test
    public void testProfileOptionsArray1(){
        String[] profileOptions = new String[]{"Messages", "Friends", "My Paths", "My Account"};
        assertEquals(profileOptions[0], profileActivity.profileOptions[0]);
    }

    // tests that the second option in the list view displays exactly "Friends"
    @Test
    public void testProfileOptionsArray2(){
        String[] profileOptions = new String[]{"Messages", "Friends", "My Paths", "My Account"};
        assertEquals(profileOptions[1], profileActivity.profileOptions[1]);
    }

    // tests that the third option in the list view displays exactly "My Paths"
    @Test
    public void testProfileOptionsArray3(){
        String[] profileOptions = new String[]{"Messages", "Friends", "My Paths", "My Account"};
        assertEquals(profileOptions[2], profileActivity.profileOptions[2]);
    }

    //test that the fourth option in the list view displays exactly "My Account"
    @Test
    public void testProfileOptionsArray4() {
        String[] profileOptions = new String[]{"Messages", "Friends", "My Paths", "My Account"};
        assertEquals(profileOptions[3], profileActivity.profileOptions[3]);
    }

    // tests that the first option in the list view when clicked brings user to MessagesActivity.java
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

    // tests that the second option in the list view when clicked brings user to PubPathsActivity.java
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

    // tests that the third option in the list view when clicked brings user to SettingsActivity.java
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

    // tests that the bottom navigation bar for the profile activity exists
    @Test
    public void testBottomMenuBarExists(){
        BottomNavigationView bottomNavigationView = profileActivity.bottomNavigationView;
        assertNotNull(bottomNavigationView);
    }

    // tests that the bottom navigation bar for the profile activity uses the correct menu xml file
    @Test
    public void testBottomMenuBarHasCorrectID(){
        BottomNavigationView bottomNavigationView = profileActivity.bottomNavigationView;
        int ID = bottomNavigationView.getId();
        int expectedID = R.id.bottom_navigation;
        assertEquals(ID, expectedID);
    }

    // setting profileActivity to null to end testing
    @After
    public void tearDown() throws Exception {
        profileActivity = null;
    }
}