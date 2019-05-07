package com.example.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

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

    // test that the send button is not null when the activity is run
    @Test
    public void testSendButtonExists(){
        FloatingActionButton sendButton = messagesActivity.fab;
        assertNotNull(sendButton);
    }

    // test that the send button uses the correct button
    @Test
    public void testSendButtonHasCorrectID(){
        FloatingActionButton sendButton = messagesActivity.fab;
        int ID = sendButton.getId();
        int expectedID = R.id.fab;
        assertEquals(ID, expectedID);
    }

    // test that the edit text view is not null when the activity is run
    @Test
    public void testEditTextExists(){
        EditText input = messagesActivity.input;
        assertNotNull(input);
    }

    // test that the edit text view uses the correct button
    @Test
    public void testEditTextHasCorrectID(){
        EditText input = messagesActivity.input;
        int ID = input.getId();
        int expectedID = R.id.input;
        assertEquals(ID, expectedID);
    }


    @After
    public void tearDown() throws Exception {
        messagesActivity = null;
    }
}