package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import com.google.ar.core.Anchor;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class MainARTest{
    @Rule
    public ActivityTestRule<MainAR> mainARActivityTestRule = new ActivityTestRule<MainAR>(MainAR.class);

    public MainAR mainAr = null;

    @Before
    public void setUp() throws Exception{
        mainAr = mainARActivityTestRule.getActivity();
    }

    // As long as arFrag exists and ar is required, the AR session will run. The rest of the AR features
    // will be tested just by testing the app itself and seeing that the anchor drops, that the anchor saves
    // to firebase, and that the anchors are rendered properly.

    @Test
    public void isArRequiredTest() {
        boolean bool = mainAr.arFragment.isArRequired();
        assertTrue(bool);
    }

}
