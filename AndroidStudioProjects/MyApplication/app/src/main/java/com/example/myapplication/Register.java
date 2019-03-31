package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;


public class Register extends AppCompatActivity {

    ScrollView scrollView;
    TextView UBLostTextView;
    TextView helpTextView;
    AutoCompleteTextView username;
    AutoCompleteTextView password;
    AutoCompleteTextView confirm_password;
    RadioButton radioButton;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        scrollView = findViewById(R.id.scrollView);
        UBLostTextView = findViewById(R.id.UBlostTextView);
        helpTextView = findViewById(R.id.helpTextView);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        radioButton = findViewById(R.id.radioButton);

        registerButton = findViewById(R.id.registerButton);

        Spinner status = findViewById(R.id.status);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        status.setAdapter(adapter);


        //register button functionality -- TO BE IMPLEMENTED 03/28
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //change to new view
            }
        });

        getWindow().setBackgroundDrawableResource(R.drawable.darkenbackground);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
}
