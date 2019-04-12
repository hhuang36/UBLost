package com.example.myapplication;

        import android.app.Activity;
        import android.app.Instrumentation;
        import android.support.test.filters.LargeTest;
        import android.support.test.rule.ActivityTestRule;
        import android.support.test.runner.AndroidJUnit4;
        import android.text.SpannableString;
        import android.text.style.ClickableSpan;
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
        import org.junit.runner.RunWith;
        import org.w3c.dom.Text;

        import static android.support.test.InstrumentationRegistry.getInstrumentation;
        import static android.support.test.espresso.Espresso.onView;
        import static android.support.test.espresso.action.ViewActions.click;
        import static android.support.test.espresso.matcher.ViewMatchers.withId;
        import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest {

    @Rule
    public ActivityTestRule<Register> registerTestRule = new ActivityTestRule(Register.class);
    public Register rT = null;
    Instrumentation.ActivityMonitor homePage = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        rT = registerTestRule.getActivity();

    }

    @Test// Testing if the register activity is launching.
    public void testLaunchRegister() {
        View view = rT.findViewById(R.id.RegisterTextView);

        assertNotNull(view);
    }

    @Test//Testing if the background image view exists.
    public void testBackgroundImageView(){
        ImageView bIView = rT.findViewById(R.id.Background);
        assertNotNull(bIView);
    }

    @Test// Testing if the scroll view exists.
    public void testScrollView(){
        ScrollView sView = rT.findViewById(R.id.scrollView);
        assertNotNull(sView);
    }


    @Test// Testing if the email view exists.
    public void testEmailView(){
        AutoCompleteTextView eView = rT.findViewById(R.id.email);
        assertNotNull(eView);
    }

    // tests that the hint displayed in the email field is correct
    @Test
    public void testEmailTextIsCorrect(){
        AutoCompleteTextView eView = rT.findViewById(R.id.email);
        CharSequence emailText = eView.getHint();
        CharSequence expected = "email address";
        assertEquals(emailText, expected);
    }

    @Test// Testing if the password view exists.
    public void testPasswordView(){
        AutoCompleteTextView pView = rT.findViewById(R.id.password);
        assertNotNull(pView);
    }

    // tests that the hint displayed in the password field is correct
    @Test
    public void testPasswordTextIsCorrect(){
        AutoCompleteTextView pView = rT.findViewById(R.id.password);
        CharSequence passwordText = pView.getHint();
        CharSequence expected = "password";
        assertEquals(passwordText, expected);
    }

    @Test// Testing if the confirm password view exists.
    public void testConfirmPasswordView(){
        AutoCompleteTextView cPView = rT.findViewById(R.id.confirm_password);
        assertNotNull(cPView);
    }

    // tests that the hint displayed in the confirm password field is correct
    @Test
    public void testConfirmPasswordTextIsCorrect(){
        AutoCompleteTextView pView = rT.findViewById(R.id.confirm_password);
        CharSequence confirmPasswordText = pView.getHint();
        CharSequence expected = "confirm password";
        assertEquals(confirmPasswordText, expected);
    }

    @Test// Testing if the radio button exists.
    public void testRadioButton(){
        RadioButton rButton = rT.findViewById(R.id.radioButton);
        assertNotNull(rButton);
    }


    @Test// Testing if the register button exists.
    public void testRegisterButton(){
        Button registerButton = rT.findViewById(R.id.registerButton);
        assertNotNull(registerButton);

    }

    // tests that the text displayed in the Register Button  is correct
    @Test
    public void testRegisterButtonTextIsCorrect(){
        Button registerButton = rT.findViewById(R.id.registerButton);
        CharSequence registerButtonText = registerButton.getText();
        CharSequence expected = "Register";
        assertEquals(registerButtonText, expected);
    }

    // tests that when the user is not done filling out his or her credentials and clicks the register button, the home page should not be displayed.
    @Test
    public void testRegisterDoesNotLeadToHomePageWithIncorrectCredentials(){
        onView(withId(R.id.registerButton)).perform(click());
        Activity homeActivity = getInstrumentation().waitForMonitorWithTimeout(homePage, 5000);
        assertNull(homeActivity);
    }


    @After
    public void tearDown() throws Exception {
        rT = null;
    }
}