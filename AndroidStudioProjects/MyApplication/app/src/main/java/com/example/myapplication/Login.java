package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    ImageView UBLostLogo;
    ScrollView scrollView;
    TextView UBLostTextView;
    TextView helpTextView;
    AutoCompleteTextView username;
    AutoCompleteTextView password;
    RadioButton radioButton;
    Button loginButton;

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
        loginButton = findViewById(R.id.radioButton);

        getWindow().setBackgroundDrawableResource(R.drawable.darkenbackground);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

}
