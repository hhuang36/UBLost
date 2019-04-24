package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.support.v7.widget.CardView;

public class HomeActivity extends AppCompatActivity {
    CardView capenCard;
    CardView lockwoodCard;
    CardView musicCard;
    CardView obrianCard;
    CardView davisCard;
    CardView mathCard;
    CardView alumniCard;
    CardView studentUnionCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set click listeners for each card, so it opens the appropriate activity.
        capenCard = findViewById(R.id.capenCard);
        capenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });

        lockwoodCard = findViewById(R.id.lockwoodCard);
        lockwoodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });

        musicCard = findViewById(R.id.musicCard);
        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });

        obrianCard = findViewById(R.id.obrianCard);
        obrianCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });

        davisCard = findViewById(R.id.davisCard);
        davisCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });

        mathCard = findViewById(R.id.mathCard);
        mathCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });

        alumniCard = findViewById(R.id.alumniCard);
        alumniCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });

        studentUnionCard = findViewById(R.id.studentUnionCard);
        studentUnionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCapenOptions();
            }
        });
    }

    // Opens up the activity with floor options (e.g. 2, 3, 4)
    public void openCapenOptions(){
        Intent intent = new Intent(HomeActivity.this, CapenFloorOptions.class);
        startActivity(intent);
    }

}
