package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.*;

public class SavedPathsTest {

    @Rule
    public ActivityTestRule<SavedPaths> savedPathsActivityTestRule = new ActivityTestRule<SavedPaths>(SavedPaths.class);
    SavedPaths savedPaths = null;

    @Before
    public void setUp() throws Exception {
        savedPaths = savedPathsActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        savedPaths = null;
    }
}