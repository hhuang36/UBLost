package com.example.myapplication;

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

import static org.junit.Assert.*;

public class ProfileActivityTest {
    @Rule
    public ActivityTestRule<ProfileActivity> profileActivityActivityTestRule = new ActivityTestRule<ProfileActivity>(ProfileActivity.class);

    ProfileActivity profileActivity = null;

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


    @After
    public void tearDown() throws Exception {
        profileActivity = null;
    }
}