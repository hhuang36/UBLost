package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule(LoginActivity.class);
    public LoginActivity lT = null;
    Instrumentation.ActivityMonitor homePage = getInstrumentation().addMonitor(HomeScreen.class.getName(), null, false);
    Instrumentation.ActivityMonitor loginPage = getInstrumentation().addMonitor(LoginActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor registerPage = getInstrumentation().addMonitor(RegisterActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        lT = loginActivityTestRule.getActivity();
    }

    // test that the LoginActivityTest activity is not null when the application is run
    @Test
    public void testLaunch(){
       // assertNotNull(lT);
    }

    // tests that the ImageView is displayed on screen
    @Test
    public void testImageViewExists(){
        ImageView iv = lT.findViewById(R.id.UBLostLogo);
        assertNotNull(iv);
    }

    // tests that the ScrollView is displayed on screen
    @Test
    public void testScrollViewExists(){
        ScrollView sv = lT.findViewById(R.id.scrollView);
        assertNotNull(sv);
    }

    // tests that the TextView is displayed on screen
    @Test
    public void testUBLostTextViewExists(){
        TextView tv = lT.findViewById(R.id.UBlostTextView);
        assertNotNull(tv);
    }

    // tests that the Password TextView is displayed on screen
    @Test
    public void testPasswordTextViewExists(){
        AutoCompleteTextView atv = lT.findViewById(R.id.password);
        assertNotNull(atv);
    }
    //tests that the Password Text Views displays correct hint
    @Test
    public void testPasswordTextViewText(){
        TextView tv = lT.findViewById(R.id.password);
        CharSequence pass = tv.getHint();
        CharSequence actual = "password";
        assertEquals(pass, actual);
    }
    @Test
    public void testEmailTextViewExists(){
        AutoCompleteTextView atv = lT.findViewById(R.id.email);
        assertNotNull(atv);
    }
    //tests that the Email Text Views displays correct hint
    @Test
    public void testEmailText(){
        TextView tv = lT.findViewById(R.id.email);
        CharSequence Email = tv.getHint();
        CharSequence actual = "email address";
        assertEquals(Email, actual);
    }

    // tests that the login button is displayed on screen
    @Test
    public void testLoginButtonExists(){
        Button button = lT.findViewById(R.id.loginButton);
        assertNotNull(button);
    }
    //tests that the LoginActivity Button says LoginActivity
    @Test
    public void loginButtonText(){
        Button button = lT.findViewById(R.id.loginButton);
        CharSequence Login = button.getText();
        CharSequence actual = "LoginActivity";
        assertEquals(Login, actual);
    }

    // tests that the registerActivity button is displayed on screen
    @Test
    public void testRegisterButtonExists() {
        Button button = lT.findViewById(R.id.registerButton);
        assertNotNull(button);
    }
    //tests that the RegisterActivity Button says RegisterActivity
    @Test
    public void registerButtonText(){
        Button button = lT.findViewById(R.id.registerButton);
        CharSequence Register = button.getText();
        CharSequence actual = "RegisterActivity";
        assertEquals(Register, actual);
    }
    //testing when registerActivity button it clicked, it opens the registerActivity page or not
    @Test
    public void testRegisterButtonLeadsToRegisterPage(){
        onView(withId(R.id.registerButton)).perform(click());
        Activity registerActivity = getInstrumentation().waitForMonitorWithTimeout(registerPage, 5000);
        assertNotNull(registerActivity);
        registerActivity.finish();

    }


    // tests that when correct credentials are entered that the user is brought to the home page
    @Test
    public void testLoginButtonFunctionality(){
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.email));
        appCompatAutoCompleteTextView.perform(replaceText("hartloff@buffalo.edu"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.password));
        appCompatAutoCompleteTextView2.perform(replaceText("123456"), closeSoftKeyboard());

        onView(withId(R.id.loginButton)).perform(click());
        Activity home = getInstrumentation().waitForMonitorWithTimeout(homePage, 5000);
        assertNotNull(home);
        home.finish();
    }

    @Test
    public void testLoginButtonIncorrectCredentialsFunctionality(){
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.email));
        appCompatAutoCompleteTextView.perform(replaceText("hartloff@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.password));
        appCompatAutoCompleteTextView2.perform(replaceText("hartlof"), closeSoftKeyboard());

        onView(withId(R.id.loginButton)).perform(click());
        Activity login = getInstrumentation().waitForMonitorWithTimeout(loginPage, 5000);
        assertNotNull(login);
        login.finish();
    }

    @After
    public void tearDown() throws Exception {
        lT = null;
    }
}