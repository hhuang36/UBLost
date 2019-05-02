package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.widget.ImageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavedPathsTest {

    @Rule
    public ActivityTestRule<SavedPaths> savedPathsActivityTestRule = new ActivityTestRule<SavedPaths>(SavedPaths.class);
    SavedPaths savedPaths = null;

    @Before
    public void setUp() throws Exception {
        savedPaths = savedPathsActivityTestRule.getActivity();
    }

    @Test
    public void testActivityNotNull(){
        assertNotNull(savedPaths);
    }

    @Test
    public void testImageViewExists(){
        ImageView imageView = savedPaths.imageView;
        assertNotNull(imageView);
    }

    @Test
    public void testImageViewHasCorrectID(){
        ImageView imageView = savedPaths.imageView;
        int ID = imageView.getId();
        int expectedID = R.id.imgView;
        assertEquals(ID, expectedID);
    }

    @After
    public void tearDown() throws Exception {
        savedPaths = null;
    }
}