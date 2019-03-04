package com.example.myapplication;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout menuDrawerLayout;
    private ActionBarDrawerToggle menuToggle;
    private Button floorplanButton;
    private Button navigateMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuDrawerLayout = findViewById(R.id.drawerLayout);
        menuToggle = new ActionBarDrawerToggle(this, menuDrawerLayout, R.string.open, R.string.close);

        menuDrawerLayout.addDrawerListener(menuToggle);
        menuToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        floorplanButton = findViewById(R.id.floorplanButton);
        floorplanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFloorPlan();
            }
        });

        navigateMe = findViewById(R.id.NavigateMe);
        navigateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNavigateMe();
            }
        });

    }

    public void openFloorPlan(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openNavigateMe(){
        Intent intent = new Intent(this, HomeActivity2.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem x){
        if(menuToggle.onOptionsItemSelected(x)) {
            return true;
        }
        return super.onOptionsItemSelected(x);
    }


}
