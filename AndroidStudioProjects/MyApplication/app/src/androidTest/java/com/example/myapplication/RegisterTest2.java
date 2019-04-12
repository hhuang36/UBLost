package com.example.myapplication;


import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RegisterTest2 {

    @Rule
    public ActivityTestRule<Register> registerTestRule = new ActivityTestRule<>(Register.class);
    Instrumentation.ActivityMonitor loginPage = getInstrumentation().addMonitor(Login.class.getName(), null, false);

    Register register = null;
    @Before
    public void before(){
        register = registerTestRule.getActivity();
    }

    @Test
    public void testRegisterWithoutEmail() {
        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to email
        onView(withId(R.id.email)).check(matches(hasErrorText("Email is required!")));
    }

    @Test
    public void testInvalidEmail() {
        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(replaceText("test"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to email
        onView(withId(R.id.email)).check(matches(hasErrorText("Invalid email address")));
    }

    @Test
    public void testRegisterWithoutPassword() {
        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(replaceText("test@gmail.com"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to password
        onView(withId(R.id.password)).check(matches(hasErrorText("Password is required!")));
    }

    @Test
    public void testRegisterWithoutPasswordConfirm() {
        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(replaceText("test@gmail.com"), closeSoftKeyboard());

        // click password & type in 123456
        ViewInteraction appCompatAutoCompleteTextView3 = onView(withId(R.id.password));
        appCompatAutoCompleteTextView3.perform(replaceText("123456"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to confirm password
        onView(withId(R.id.confirm_password)).check(matches(hasErrorText("Confirmation required!")));
    }

    @Test
    public void testRegisterWithoutPasswordMatching() {
        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(replaceText("test@gmail.com"), closeSoftKeyboard());

        // click password & type in 123456
        ViewInteraction appCompatAutoCompleteTextView3 = onView(withId(R.id.password));
        appCompatAutoCompleteTextView3.perform(replaceText("123456"), closeSoftKeyboard());

        // click confirm password & type in 12345
        ViewInteraction appCompatAutoCompleteTextView4 = onView(withId(R.id.confirm_password));
        appCompatAutoCompleteTextView4.perform(replaceText("12345"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to confirm password
        onView(withId(R.id.confirm_password)).check(matches(hasErrorText("Passwords do not match!")));
    }

    // tests that when the user successfully entered all fields that register brings the user back to the login activity
    @Test
    public void testRegisterButton(){
        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(replaceText("asdf@gmail.com"), closeSoftKeyboard());

        // click password & type in 123456
        ViewInteraction appCompatAutoCompleteTextView3 = onView(withId(R.id.password));
        appCompatAutoCompleteTextView3.perform(replaceText("123456"), closeSoftKeyboard());

        // click confirm password & type in 12345
        ViewInteraction appCompatAutoCompleteTextView4 = onView(withId(R.id.confirm_password));
        appCompatAutoCompleteTextView4.perform(replaceText("123456"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.radioButton)).perform(click());
        onView(withId(R.id.registerButton)).perform(click());
        Activity login = getInstrumentation().waitForMonitorWithTimeout(loginPage, 5000);
        assertNotNull(login);
        login.finish();

    }


}
