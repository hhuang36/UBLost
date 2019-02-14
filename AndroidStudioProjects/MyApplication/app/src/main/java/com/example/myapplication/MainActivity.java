package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout menuDrawerLayout;
    private ActionBarDrawerToggle menuToggle;
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem x){
        if(menuToggle.onOptionsItemSelected(x)) {
            return true;
        }
        return super.onOptionsItemSelected(x);
    }
}
