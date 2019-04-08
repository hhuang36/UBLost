package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;

    ImageView UBLostLogo;
    ScrollView scrollView;
    TextView UBLostTextView;
    TextView helpTextView;
    AutoCompleteTextView username;
    AutoCompleteTextView password;
    RadioButton radioButton;
    Button loginButton;
    Button registerButton;

    //security mechanism variables
    TextView incorrectCred;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        UBLostLogo = findViewById(R.id.UBLostLogo);
        scrollView = findViewById(R.id.scrollView);
        UBLostTextView = findViewById(R.id.UBlostTextView);
        helpTextView = findViewById(R.id.helpTextView);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        radioButton = findViewById(R.id.radioButton);
        loginButton = findViewById(R.id.loginButton);
        registerButton = this.findViewById(R.id.registerButton);

        //login button functionality - database traversal to be implemented 03/28
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //dummy testing data - 03/28
                //editTextUsername and editTextPassword matching
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Intent loggedIn = new Intent(Login.this, SplashScreen.class);
                    startActivity(loggedIn);
                    //implement database traversal to verify login information
                }else{ /*security mechanism - login disabled after 3 failed attempts*/
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    counter --;
                    //disable login button if credentials wrong
                    if (counter == 0) {
                        loginButton.setEnabled(false);
                    }
                }
            }
        });

        //register button functionality -- TO BE IMPLEMENTED 03/28
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);

            }
        });

        getWindow().setBackgroundDrawableResource(R.drawable.darkenbackground);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
}
