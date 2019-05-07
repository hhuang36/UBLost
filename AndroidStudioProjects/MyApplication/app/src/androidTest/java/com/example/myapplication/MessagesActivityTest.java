package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessagesActivityTest {
    @Rule
    ActivityTestRule<MessagesActivity> messagesActivityActivityTestRule = new ActivityTestRule<MessagesActivity>(MessagesActivity.class);
    MessagesActivity messagesActivity = null;

    @Before
    public void setUp() throws Exception {
        messagesActivity = messagesActivityActivityTestRule.getActivity();
    }

    @Test
    public void testMessagesActivityNotNull(){
        assertNotNull(messagesActivity);
    }

    @After
    public void tearDown() throws Exception {
        messagesActivity = null;
    }
}