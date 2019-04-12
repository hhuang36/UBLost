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
        import android.widget.TextView;

public class SplashScreen extends AppCompatActivity { // THIS IS THE HOME PAGE
    private DrawerLayout menuDrawerLayout;
    private ActionBarDrawerToggle menuToggle;
     Button floorplanButton;
     Button navigateMe;
    private Button Home;
    //TextView tv;
    public static  int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //openSplashScreen();
        Home = (Button) findViewById(R.id.home_page);

        //tv = findViewById(R.id.textView);
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


