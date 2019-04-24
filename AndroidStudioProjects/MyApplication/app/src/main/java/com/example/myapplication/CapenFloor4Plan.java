package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CapenFloor4Plan extends AppCompatActivity {

    ImageView capenF4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capen_floor4_plan);
        capenF4 = findViewById(R.id.capenF4);
        capenF4.setImageResource(R.mipmap.capen_floor_4);

    }
}
