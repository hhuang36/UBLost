package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class HomeActivity extends AppCompatActivity {
    Button capenButton;
    Button lockwoodButton;
    Button musicButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        capenButton = findViewById(R.id.CapenButton);
        capenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });
        lockwoodButton = findViewById(R.id.LockWoodButton);
        lockwoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });
        musicButton = findViewById(R.id.MusicButton);
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });
    }

    public void openCapenOptions(){
        Intent intent = new Intent(HomeActivity.this, CapenFloorOptions.class);
        startActivity(intent);
    }

}
