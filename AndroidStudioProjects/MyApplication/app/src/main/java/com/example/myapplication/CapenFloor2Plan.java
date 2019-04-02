package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CapenFloor2Plan extends AppCompatActivity {

    ImageView capenF2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capen_floor2_plan);
        capenF2 = findViewById(R.id.capenF2);
        capenF2.setImageResource(R.mipmap.capen_floor_3);
    }
}
