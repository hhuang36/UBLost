package com.example.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LawFloor2Plan extends AppCompatActivity {
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plans);


        ViewPager viewPager = findViewById(R.id.gallery);
        adapter = new ImageAdapter(this);
        adapter.getmImageIds().add(R.mipmap.law_2);
        adapter.getmImageIds().add(R.mipmap.law_3);
        adapter.getmImageIds().add(R.mipmap.law_4);
        adapter.getmImageIds().add(R.mipmap.law_5);
        adapter.getmImageIds().add(R.mipmap.law_6);
        adapter.getmImageIds().add(R.mipmap.law_7);
        viewPager.setAdapter(adapter);
    }
}
