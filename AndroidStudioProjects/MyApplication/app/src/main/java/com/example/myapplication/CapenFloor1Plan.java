package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CapenFloor1Plan extends AppCompatActivity {
    TextView capenF1TextView;
    ImageView capenF1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capen_floor1_plan);
        capenF1TextView = findViewById(R.id.CapenFloor1TextView);
        capenF1 = findViewById(R.id.capenF1);
        capenF1.setImageResource(R.mipmap.capen_floor_2);
    }


}
