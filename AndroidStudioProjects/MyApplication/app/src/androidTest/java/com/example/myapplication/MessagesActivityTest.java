package com.example.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Date;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MessagesActivityTest {
    @Rule
    public ActivityTestRule<MessagesActivity> messagesActivityActivityTestRule = new ActivityTestRule<>(MessagesActivity.class);

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
        ViewInteraction appCompatEditTextView = onView(withId(R.id.input));
        appCompatEditTextView.perform(replaceText("testEditTextExists"), closeSoftKeyboard());
        onView(withId(R.id.fab)).perform(click());
        EditText input = messagesActivity.input;
        assertNotNull(input);
    }

    // test that the edit text view uses the correct button
    @Test
    public void testEditTextHasCorrectID(){
        ViewInteraction appCompatEditTextView = onView(withId(R.id.input));
        appCompatEditTextView.perform(replaceText("testEditTextHasCorrectID"), closeSoftKeyboard());
        onView(withId(R.id.fab)).perform(click());
        EditText input = messagesActivity.input;
        int ID = input.getId();
        int expectedID = R.id.input;
        assertEquals(ID, expectedID);
    }

    // test that when a message is sent, the message user receives the current user's emails
    @Test
    public void testMessageUserNotNull(){
        ViewInteraction appCompatEditTextView = onView(withId(R.id.input));
        appCompatEditTextView.perform(replaceText("testMessageUser"), closeSoftKeyboard());
        onView(withId(R.id.fab)).perform(click());
        TextView messageUser = messagesActivity.messageUser;
        assertNotNull(messageUser);
    }

    // test that when a message is sent, the message text receives the current user's input text
    @Test
    public void testMessageTextNotNull(){
        ViewInteraction appCompatEditTextView = onView(withId(R.id.input));
        appCompatEditTextView.perform(replaceText("testMessageText"), closeSoftKeyboard());
        onView(withId(R.id.fab)).perform(click());
        TextView messageText = messagesActivity.messageText;
        assertNotNull(messageText);
    }

    // test that when a message is sent, the message time receives the current user's time stamp
    @Test
    public void testMessageTimeNotNull(){
        ViewInteraction appCompatEditTextView = onView(withId(R.id.input));
        appCompatEditTextView.perform(replaceText("testMessageTime"), closeSoftKeyboard());
        onView(withId(R.id.fab)).perform(click());
        TextView messageTime= messagesActivity.messageTime;
        assertNotNull(messageTime);
    }
    
    @After
    public void tearDown() throws Exception {
        messagesActivity = null;
    }
}