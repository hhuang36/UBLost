package com.example.myapplication;


import android.app.Instrumentation;
import android.content.Intent;
import android.provider.ContactsContract;
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

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.openLinkWithText;
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
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RegisterTest2 {

    @Rule
    public ActivityTestRule<Register> registerTestRule = new ActivityTestRule<>(Register.class);

    @Test
    public void registerTest2() {
        ViewInteraction appCompatSpinner2 = onView(withId(R.id.status_spinner));
        appCompatSpinner2.perform(click());

        DataInteraction appCompatCheckedTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);
        appCompatCheckedTextView2.perform(click());

        ViewInteraction spinner = onView(
                allOf(withId(R.id.status_spinner),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        spinner.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.text1), withText("Student"),
                        childAtPosition(
                                allOf(withId(R.id.status_spinner),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Student")));

        ViewInteraction editText = onView(
                allOf(withId(R.id.username), withHint("username"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                2),
                        isDisplayed()));
        editText.check(matches(isDisplayed()));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.username), withHint("username"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                2),
                        isDisplayed()));
        editText2.check(matches(withHint("username")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.email), withHint("email address"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                3),
                        isDisplayed()));
        editText3.check(matches(isDisplayed()));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.email), withHint("email address"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                3),
                        isDisplayed()));
        editText4.check(matches(withHint("email address")));

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.password), withHint("password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                4),
                        isDisplayed()));
        editText5.check(matches(withHint("password")));

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.password), withHint("password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                4),
                        isDisplayed()));
        editText6.check(matches(isDisplayed()));

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.confirm_password), withHint("confirm password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                5),
                        isDisplayed()));
        editText7.check(matches(isDisplayed()));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.confirm_password), withHint("confirm password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                5),
                        isDisplayed()));
        editText8.check(matches(withHint("confirm password")));

        ViewInteraction radioButton = onView(
                allOf(withId(R.id.radioButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                6),
                        isDisplayed()));
        radioButton.check(matches(isDisplayed()));

        ViewInteraction button = onView(
                allOf(withId(R.id.registerButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                7),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.helpTextView), withText("Already have an account? Login now"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                8),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.helpTextView), withText("Already have an account? Login now"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                8),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.RegisterTextView), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                0),
                        isDisplayed()));
        textView4.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.RegisterTextView), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                0),
                        isDisplayed()));
        textView5.check(matches(isDisplayed()));

        ViewInteraction appCompatAutoCompleteTextView = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                2)));
        appCompatAutoCompleteTextView.perform(scrollTo(), click());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView),
                                        0),
                                2)));
        appCompatAutoCompleteTextView2.perform(scrollTo(), replaceText("test"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(withId(R.id.registerButton));
        appCompatButton2.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void testRegisterWithoutUsername() {
        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to username
        onView(withId(R.id.username)).check(matches(hasErrorText("Username is required!")));
    }


    @Test
    public void testRegisterWithoutEmail() {
        // click username & type in test
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.username));
        appCompatAutoCompleteTextView.perform(scrollTo(), replaceText("test"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to email
        onView(withId(R.id.email)).check(matches(hasErrorText("Email is required!")));
    }

    @Test
    public void testInvalidEmail() {
        // click username & type in test
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.username));
        appCompatAutoCompleteTextView.perform(scrollTo(), replaceText("test"), closeSoftKeyboard());

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
        // click username & type in test
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.username));
        appCompatAutoCompleteTextView.perform(replaceText("test"), closeSoftKeyboard());

        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(replaceText("test@gmail.com"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to email
        onView(withId(R.id.password)).check(matches(hasErrorText("Password is required!")));
    }

    @Test
    public void testRegisterWithoutPasswordConfirm() {
        // click username & type in test
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.username));
        appCompatAutoCompleteTextView.perform(replaceText("test"), closeSoftKeyboard());

        // click email & type in test@gmail.com
        ViewInteraction appCompatAutoCompleteTextView2 = onView(withId(R.id.email));
        appCompatAutoCompleteTextView2.perform(replaceText("test@gmail.com"), closeSoftKeyboard());

        // click password & type in 123456
        ViewInteraction appCompatAutoCompleteTextView3 = onView(withId(R.id.password));
        appCompatAutoCompleteTextView3.perform(replaceText("123456"), closeSoftKeyboard());

        // click on register button
        onView(withId(R.id.registerButton)).perform(click());

        // check if error message pops up next to email
        onView(withId(R.id.confirm_password)).check(matches(hasErrorText("Confirmation required!")));
    }

    @Test
    public void testRegisterWithoutPasswordMatching() {
        // click username & type in test
        ViewInteraction appCompatAutoCompleteTextView = onView(withId(R.id.username));
        appCompatAutoCompleteTextView.perform(replaceText("test"), closeSoftKeyboard());

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

        // check if error message pops up next to email
        onView(withId(R.id.confirm_password)).check(matches(hasErrorText("Passwords do not match!")));
    }

    @Test
    public void testReturnToLoginLink() {
        //TODO

    }



}
