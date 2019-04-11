package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.text.Layout;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class LoginTest {

    @Rule
    public ActivityTestRule<Login> loginActivityTestRule = new ActivityTestRule(Login.class);
    public Login lT = null;
    Instrumentation.ActivityMonitor homePage = getInstrumentation().addMonitor(SplashScreen.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        lT = loginActivityTestRule.getActivity();
    }

    // test that the LoginTest activity is not null when the application is run
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

    // tests that the login button is displayed on screen
    @Test
    public void testLoginButtonExists(){
        Button button = lT.findViewById(R.id.loginButton);
        assertNotNull(button);
    }

    // tests that the register button is displayed on screen
    @Test
    public void testRegisterButtonExists() {
        Button button = lT.findViewById(R.id.registerButton);
        assertNotNull(button);
    }

    @Test
    public void testLoginButtonFunctionality(){
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.email));
        appCompatAutoCompleteTextView.perform(replaceText("hartloff@gmail.com"), closeSoftKeyboard());

        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.password));
        appCompatAutoCompleteTextView2.perform(replaceText("hartloff"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.loginButton)).perform(click());
        Activity home = getInstrumentation().waitForMonitorWithTimeout(homePage, 5000);
        assertNotNull(home);
        home.finish();
    }

    @After
    public void tearDown() throws Exception {
        lT = null;
    }
}