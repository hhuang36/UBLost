package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class FriendsActivityTest {
    @Rule
    public ActivityTestRule<FriendsActivity> friendsActivityTestRule = new ActivityTestRule<>(FriendsActivity.class);

    private FriendsActivity friendsActivity = null;


    @Before
    public void setUp() throws Exception {
        friendsActivity = friendsActivityTestRule.getActivity();
    }

    // test that the activity is not null when the app is run
    @Test
    public void testfriendsActivityNotNull(){
        assertNotNull(friendsActivity);
    }

    //test that the list view is not null when
    @Test
    public void testFriendsListExists() {
        ListView friendsList = friendsActivity.listFriends;
        assertNotNull(friendsList);
    }


    @After
    public void tearDown() throws Exception {
        friendsActivity = null;
    }
}