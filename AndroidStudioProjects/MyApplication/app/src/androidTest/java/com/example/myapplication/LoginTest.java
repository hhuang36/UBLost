package com.example.myapplication;

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

import static org.junit.Assert.*;

public class LoginTest extends android.app.Activity{

    @Rule
    public ActivityTestRule<Login> loginActivityTestRule = new ActivityTestRule(Login.class);
    public Login lT = null;

    @Before
    public void setUp() throws Exception {
        lT = loginActivityTestRule.getActivity();
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

    // tests that the HelpTextView is displayed on screen
    @Test
    public void testHelpTextViewExists(){
        TextView tv = lT.findViewById(R.id.helpTextView);
        assertNotNull(tv);
    }

    // tests that the Username TextView is displayed on screen
    @Test
    public void testUsernameTextViewExists(){
        AutoCompleteTextView atv = lT.findViewById(R.id.username);
        assertNotNull(atv);
    }

    // tests that the Password TextView is displayed on screen
    @Test
    public void testPasswordTextViewExists(){
        AutoCompleteTextView atv = lT.findViewById(R.id.password);
        assertNotNull(atv);
    }

    // tests that the RadioButton is displayed on screen
    @Test
    public void testRadioButtonExists(){
        RadioButton button = lT.findViewById(R.id.radioButton);
        assertNotNull(button);
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

    @After
    public void tearDown() throws Exception {
        lT = null;
    }
}