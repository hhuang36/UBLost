package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

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
        profileStatus = findViewById(R.id.profileStatus);
        profilePubPath = findViewById(R.id.profilePubPath);
        profilePubPathIcon = findViewById(R.id.profilePubPathIcon);
        profileSettings = findViewById(R.id.profileSettings);
        profileSettingsIcon = findViewById(R.id.profileSettingsIcon);
        profileMessage = findViewById(R.id.profileMessage);
        profileMsgIcon = findViewById(R.id.profileMsgIcon);

    }
}
