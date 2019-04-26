package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity{

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;
    private FirebaseAuth mAuth;

    //activity attributes
    ImageView profileAvatar;
    TextView profileName;
    TextView profileStatus;
    Button profilePubPath;
    ImageView profilePubPathIcon;
    Button profileSettings;
    ImageView profileSettingsIcon;
    Button profileMessage;
    ImageView profileMsgIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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

        //Message Button
        profileMsgIcon = findViewById(R.id.profileMsgIcon);
        profileMessage = findViewById(R.id.profileMessage);
        profileMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ProfileActivity.this, MessagesActivity.class);
                startActivity(intent);
            }
        });

        //Public Paths Button
        profilePubPathIcon = findViewById(R.id.profilePubPathIcon);
        profilePubPath = findViewById(R.id.profilePubPath);
        profilePubPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PubPathsActivity.class);
                startActivity(intent);
            }
        });

        //Settings Button
        profileSettingsIcon = findViewById(R.id.profileSettingsIcon);
        profileSettings = findViewById(R.id.profileSettings);
        profileSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

}
