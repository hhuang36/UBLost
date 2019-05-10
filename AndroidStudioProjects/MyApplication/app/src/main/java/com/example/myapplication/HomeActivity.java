package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_building_options);

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
                openLockwoodOptions();
            }
        });

        musicCard = findViewById(R.id.musicCard);
        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMusicOptions();
            }
        });

        obrianCard = findViewById(R.id.obrianCard);
        obrianCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLawOptions();
            }
        });

        davisCard = findViewById(R.id.davisCard);
        davisCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUnderConstruction();
            }
        });

        mathCard = findViewById(R.id.mathCard);
        mathCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUnderConstruction();
            }
        });

        alumniCard = findViewById(R.id.alumniCard);
        alumniCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUnderConstruction();
            }
        });

        studentUnionCard = findViewById(R.id.studentUnionCard);
        studentUnionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUnderConstruction();
            }
        });
    }

    // Opens up the activity with floor options (e.g. 2, 3, 4)
    public void openCapenOptions(){
        Intent intent = new Intent(HomeActivity.this, CapenFloorOptions.class);
        startActivity(intent);
    }

    // Opens up the activity with floor options (e.g. 2, 3, 4)
    public void openLockwoodOptions(){
        Intent intent = new Intent(HomeActivity.this, LockwoodFloorOptions.class);
        startActivity(intent);
    }

    // Opens up the activity with floor options (e.g. 2, 3, 4)
    public void openMusicOptions(){
        Intent intent = new Intent(HomeActivity.this, MusicFloorOptions.class);
        startActivity(intent);
    }

    public void openLawOptions(){
        Intent intent = new Intent(HomeActivity.this, LawFloorOptions.class);
        startActivity(intent);
    }

    public void openUnderConstruction(){
        Intent intent = new Intent(HomeActivity.this, UnderConstructionActivity.class);
        startActivity(intent);
    }

}
