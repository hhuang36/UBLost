package com.example.myapplication;

import android.support.annotation.FloatRange;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class CapenFloorOptionsTest {


    @Rule
    public ActivityTestRule<CapenFloorOptions> capenFloorOptionsActivityTestRule = new ActivityTestRule(CapenFloorOptions.class);

    public CapenFloorOptions cFO = null;

    @Before
    public void setUp() throws Exception{
        cFO = capenFloorOptionsActivityTestRule.getActivity();
    }

    @Test
    public void testCapenFloorStringArray1(){
        String FloorTexts[] = new String [] {"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[0], cFO.capenFloorButtons[0]);
    }

    @Test
    public void testCapenFloorStringArray2(){
        String FloorTexts[] = new String [] {"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[1], cFO.capenFloorButtons[1]);
    }

    @Test
    public void testCapenFloorStringArray3(){
        String FloorTexts[] = new String [] {"Floor 2", "Floor 3", "Floor 4"};
        assertEquals(FloorTexts[2], cFO.capenFloorButtons[2]);
    }

    @Test
    public void testFloorTwo(){

    }
    @Test
    public void testFloorThree(){

    }
    @Test
    public void testFloorFloor(){

    }
    @After
    public void tearDown() throws Exception{
        cFO = null;
    }

}