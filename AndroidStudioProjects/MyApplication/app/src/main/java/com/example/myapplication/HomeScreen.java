package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity { // THIS IS THE HOME PAGE
    private DrawerLayout menuDrawerLayout;
    private ActionBarDrawerToggle menuToggle;
     Button floorplanButton;
     Button navigateMe;
    private Button Home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home = findViewById(R.id.home_page);


        menuDrawerLayout = findViewById(R.id.drawerLayout);
        menuToggle = new ActionBarDrawerToggle(this, menuDrawerLayout, R.string.open, R.string.close);

        menuDrawerLayout.addDrawerListener(menuToggle);
        menuToggle.syncState();

//        floorplanButton = findViewById(R.id.floorplanButton);
//        floorplanButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openFloorPlan();
//            }
//        });
//
//        navigateMe = findViewById(R.id.NavigateMe);
//        navigateMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openNavigateMe();
//            }
//        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_navigate:
                        openNavigateMe();
                        break;
                    case R.id.action_map:
                        openFloorPlan();
                        break;
                    case R.id.action_nearby:
                        Toast.makeText(HomeScreen.this, "Nearby", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }

    public void openFloorPlan(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openNavigateMe(){
        Intent intent = new Intent(this, LocationActivity.class);
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


