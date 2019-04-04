package com.example.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.graphics.ImageDecoder;
import android.support.test.rule.ActivityTestRule;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.w3c.dom.Text;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class CapenFloor1PlanTest {
    @Rule
    public ActivityTestRule<CapenFloor1Plan> capenFloor1PlanActivityTestRule = new ActivityTestRule(CapenFloor1Plan.class);

    public CapenFloor1Plan cF1P = null;

    @Before
    public void setUp() throws Exception{
        cF1P = capenFloor1PlanActivityTestRule.getActivity();
    }

    // test that the TextView appears on screen
    @Test
    public void testTextViewNotNull(){
        TextView tv = cF1P.capenF1TextView;
        assertNotNull(tv);
    }

    // test that the TextView correctly displays "Capen Floor 2"
    @Test
    public void testTextViewHasCorrectText(){
        TextView tv = cF1P.capenF1TextView;
        CharSequence text = tv.getText();
        CharSequence actual = "Capen Floor 2";
        assertEquals(text, actual);
    }

    // test that the ImageView is not null
    @Test
    public void testImageViewNotNull(){
        ImageView iv = cF1P.capenF1;
        assertNotNull(iv);
    }

    // test that the ImageView displays the right Image using Id's
    @Test
    public void testImageViewHasCorrectId(){
        ImageView iv = cF1P.capenF1;
        int id = iv.getId();
        int expected = R.id.capenF1;
        assertEquals(id, expected);
    }

    @After
    public void tearDown() throws Exception{
        cF1P = null;
    }

}
