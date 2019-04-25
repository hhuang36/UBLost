package com.example.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MusicFloor1Plan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plans);

        ViewPager viewPager = findViewById(R.id.gallery);
        ImageAdapter adapter = new ImageAdapter(this);
        adapter.getmImageIds().add(R.mipmap.music_1);
        viewPager.setAdapter(adapter);
    }
}
