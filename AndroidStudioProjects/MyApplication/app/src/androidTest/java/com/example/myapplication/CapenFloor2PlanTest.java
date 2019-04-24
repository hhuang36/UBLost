package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class CapenFloor2PlanTest {
    @Rule
    public ActivityTestRule capenFloor1PlanActivityTestRule = new ActivityTestRule(CapenFloor2Plan.class);

    private CapenFloor2Plan cF2P = null;

    @Before
    public void setUp() {
        cF2P = (CapenFloor2Plan) capenFloor1PlanActivityTestRule.getActivity();
    }

    // test that the TextView appears on screen
    @Test
    public void testTextViewNotNull(){
        TextView tv = cF2P.capenF2TextView;
        assertNotNull(tv);
    }

    // test that the TextView correctly displays "Capen Floor 2"
    @Test
    public void testTextViewHasCorrectText(){
        TextView tv = cF2P.capenF2TextView;
        CharSequence text = tv.getText();
        CharSequence actual = "Capen Floor 2";
        assertEquals(text, actual);
    }

    // test that the ImageView is not null
    @Test
    public void testImageViewNotNull(){
        ImageView iv = cF2P.capenF2;
        assertNotNull(iv);
    }

    // test that the ImageView displays the right Image using Id's
    @Test
    public void testImageViewHasCorrectId(){
        ImageView iv = cF2P.capenF2;
        int id = iv.getId();
        int expected = R.id.capenF2;
        assertEquals(id, expected);
    }

    @After
    public void tearDown() {
        cF2P = null;
    }

}
