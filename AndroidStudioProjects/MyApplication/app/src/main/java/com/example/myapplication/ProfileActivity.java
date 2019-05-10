package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity{

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;
    private FirebaseAuth mAuth;
    BottomNavigationView bottomNavigationView;
    //activity attributes
    ImageView profileAvatar;
    TextView profileName;
    TextView profileStatus;
//    Button profilePubPath;
//    ImageView profilePubPathIcon;
//    Button profileSettings;
//    ImageView profileSettingsIcon;
//    Button profileMessage;
//    ImageView profileMsgIcon;

    ListView profile_options;
    ArrayAdapter<String> adapter;
    String[] profileOptions = new String[]{"Messages", "Friends", "My Paths", "My Account"};


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_options = findViewById(R.id.profile_options_list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, profileOptions);
        profile_options.setAdapter(adapter);
        profile_options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(profileOptions[position].equals("Messages")){
                    Intent intent = new Intent(ProfileActivity.this, MessagesActivity.class);
                    startActivity(intent);
                }
                else if (profileOptions[position].equals("Friends")){
                    Intent intent = new Intent (ProfileActivity.this, FriendsActivity.class);
                    startActivity(intent);
                }else if(profileOptions[position].equals("My Paths")){
                    Intent intent = new Intent(ProfileActivity.this, PubPathsActivity.class);
                    startActivity(intent);
                } else if(profileOptions[position].equals("My Account")){
                    Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                    startActivity(intent);
                }
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
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
                    case R.id.action_paths:
                        openSavedFloorPlans();
                        break;
                    case R.id.user_profile:
                        openUserProfile();
                        break;
                }
                return true;
            }
        });

        //database
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        //activity attributes
        profileAvatar = findViewById(R.id.profileAvatar);
        profileName = findViewById(R.id.profileName);
        String name = mAuth.getCurrentUser().getEmail();
        name = name.replace("@buffalo.edu","");
        profileName.setText(name);
        profileStatus = findViewById(R.id.profileStatus);
        String status = mAuth.getCurrentUser().getUid();

//        //Message Button
//        profileMsgIcon = findViewById(R.id.profileMsgIcon);
//        profileMessage = findViewById(R.id.profileMessage);
//        profileMessage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent (ProfileActivity.this, MessagesActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //Public Paths Button
//        profilePubPathIcon = findViewById(R.id.profilePubPathIcon);
//        profilePubPath = findViewById(R.id.profilePubPath);
//        profilePubPath.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileActivity.this, PubPathsActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //Settings Button
//        profileSettingsIcon = findViewById(R.id.profileSettingsIcon);
//        profileSettings = findViewById(R.id.profileSettings);
//        profileSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    public void openFloorPlan(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openNavigateMe(){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    public void openSavedFloorPlans(){
        Intent intent = new Intent(this, SavedPaths.class);
        startActivity(intent);
    }

    public void openUserProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }


}
