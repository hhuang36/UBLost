package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CapenFloor3Plan extends AppCompatActivity {

    ImageView capenF3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capen_floor3_plan);
        capenF3 = findViewById(R.id.capenF3);
        capenF3.setImageResource(R.mipmap.capen_floor_4);

    }
}
