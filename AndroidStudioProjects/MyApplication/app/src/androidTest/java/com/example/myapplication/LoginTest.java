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
    public ActivityTestRule<LoginTest> loginTestActivityTestRule = new ActivityTestRule(LoginTest.class);
    public LoginTest lT = null;

    @Before
    public void setUp() throws Exception {
        lT = loginTestActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        assertNotNull(lT);
    }

    @Test
    public void testImageViewExists(){
        ImageView iv = lT.findViewById(R.id.UBLostLogo);
        assertNotNull(iv);
    }

    @Test
    public void testScrollViewExists(){
        ScrollView sv = lT.findViewById(R.id.scrollView);
        assertNotNull(sv);
    }

    @Test
    public void testUBLostTextViewExists(){
        TextView tv = lT.findViewById(R.id.UBlostTextView);
        assertNotNull(tv);
    }

    @Test
    public void testHelpTextViewExists(){
        TextView tv = lT.findViewById(R.id.helpTextView);
        assertNotNull(tv);
    }

    @Test
    public void testUsernameTextViewExists(){
        AutoCompleteTextView atv = lT.findViewById(R.id.username);
        assertNotNull(atv);
    }

    @Test
    public void testPasswordTextViewExists(){
        AutoCompleteTextView atv = lT.findViewById(R.id.password);
        assertNotNull(atv);
    }

    @Test
    public void testRadioButtonExists(){
        RadioButton button = lT.findViewById(R.id.radioButton);
        assertNotNull(button);
    }

    @Test
    public void testLoginButtonExists(){
        Button button = lT.findViewById(R.id.loginButton);
        assertNotNull(button);
    }

    @Test
    public void testRegisterButtonExists() {
        Button button = lT.findViewById(R.id.registerButton);
        assertNotNull(button);
    }

    @After
    public void tearDown() throws Exception {
    }
}