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

public class Login extends AppCompatActivity {

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
        registerButton = findViewById(R.id.registerButton);

        //login button functionality - database traversal to be implemented 03/28
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //dummy testing data - 03/28
                //username and password matching
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Welcome back!", Toast.LENGTH_SHORT).show();
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
                //change to new view
            }
        });

        getWindow().setBackgroundDrawableResource(R.drawable.darkenbackground);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
