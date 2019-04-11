package com.example.myapplication;

import android.app.Activity;
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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class LoginTest extends android.app.Activity{

    @Rule
    public ActivityTestRule<LoginTest> loginTestActivityTestRule = new ActivityTestRule(LoginTest.class);
    public LoginTest lT = null;

    @Before
    public void setUp() throws Exception {
        lT = loginTestActivityTestRule.getActivity();
    }

    // test that the LoginTest activity is not null when the application is run
    @Test
    public void testLaunch(){
        assertNotNull(lT);
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
    public void testTextViewText(){
        TextView tv = lT.findViewById(R.id.password);
        CharSequence pass = tv.getText();
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
        CharSequence pass = tv.getText();
        CharSequence actual = "email address";
        assertEquals(pass, actual);
    }

    // tests that the login button is displayed on screen
    @Test
    public void testLoginButtonExists(){
        Button button = lT.findViewById(R.id.loginButton);
        assertNotNull(button);
    }
    //tests that the Login Button says Login
    @Test
    public void loginButtonText(){
        Button button = lT.findViewById(R.id.loginButton);
        CharSequence pass = button.getText();
        CharSequence actual = "Login";
        assertEquals(pass, actual);
    }

    // tests that the register button is displayed on screen
    @Test
    public void testRegisterButtonExists() {
        Button button = lT.findViewById(R.id.registerButton);
        assertNotNull(button);
    }
    //tests that the Register Button says Register
    @Test
    public void registerButtonText(){
        Button button = lT.findViewById(R.id.registerButton);
        CharSequence pass = button.getText();
        CharSequence actual = "Register";
        assertEquals(pass, actual);
    }
    //testing when register button it clicked, it opens the register page or not
    @Test
    public void testRegisterButtonLeadsToRegisterPage(){
        onView(withId(R.id.registerButton)).perform(click());
        Activity registerActivity = getInstrumentation().waitForMonitorWithTimeout(registerPage, 5000);
        assertNotNull(registerActivity);
        registerActivity.finish();

    }


    @After
    public void tearDown() throws Exception {
        lT = null;
    }

}