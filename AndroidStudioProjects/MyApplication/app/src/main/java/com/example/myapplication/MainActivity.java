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
    //private ImageButton imageButton;
    private Button floorplanButton;
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run(){
//                Intent welcome = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(welcome);
//                finish();
//            }
//        }, SPLASH_TIME_OUT);

        menuDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        menuToggle = new ActionBarDrawerToggle(this, menuDrawerLayout, R.string.open, R.string.close);

        menuDrawerLayout.addDrawerListener(menuToggle);
        menuToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //imageButton = findViewById(R.id.imageButton);
        floorplanButton = findViewById(R.id.floorplanButton);
        floorplanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFloorPlan();
            }
        });
    }

    public void openFloorPlan(){
        Intent intent = new Intent(this, HomeActivity.class);
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
