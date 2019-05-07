package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

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

    // test that the activity is not null when the app is run
    @Test
    public void testMessagesActivityNotNull(){
        assertNotNull(messagesActivity);
    }

    // test that the chat log is not null when the activity is run
    @Test
    public void testChatLogExists(){
        ListView chatLog = messagesActivity.listOfMessages;
        assertNotNull(chatLog);
    }

    // test that the chat log uses the correct listview
    @Test
    public void testChatLogHasCorrectID(){
        ListView chatLog = messagesActivity.listOfMessages;
        int ID = chatLog.getId();
        int expectedID = R.id.list_of_messages;
        assertEquals(ID, expectedID);
    }
    
    @After
    public void tearDown() throws Exception {
        messagesActivity = null;
    }
}