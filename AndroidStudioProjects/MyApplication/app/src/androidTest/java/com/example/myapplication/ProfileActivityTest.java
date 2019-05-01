package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.widget.ImageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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

    @After
    public void tearDown() throws Exception {
        profileActivity = null;
    }
}