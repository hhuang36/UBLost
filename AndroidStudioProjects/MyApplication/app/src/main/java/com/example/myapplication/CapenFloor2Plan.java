package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CapenFloor2Plan extends AppCompatActivity {
    TextView capenF2TextView;
    ImageView capenF2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capen_floor2_plan);

        capenF2TextView = findViewById(R.id.CapenFloor2TextView);
        capenF2 = findViewById(R.id.capenF2);
    }


}
