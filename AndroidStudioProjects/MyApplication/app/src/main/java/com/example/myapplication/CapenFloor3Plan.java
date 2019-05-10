package com.example.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CapenFloor3Plan extends AppCompatActivity {
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plans);

        ViewPager viewPager = findViewById(R.id.gallery);
        ImageAdapter adapter = new ImageAdapter(this);
        adapter.getmImageIds().add(R.mipmap.capen_floor_2);
        adapter.getmImageIds().add(R.mipmap.capen_floor_3);
        adapter.getmImageIds().add(R.mipmap.capen_floor_4);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);

    }
}
