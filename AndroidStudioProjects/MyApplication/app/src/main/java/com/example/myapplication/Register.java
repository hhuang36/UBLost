package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.*;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.support.annotation.NonNull;

public class Register extends AppCompatActivity {
    AutoCompleteTextView username;
    AutoCompleteTextView password;
    AutoCompleteTextView confirm_password;
    AutoCompleteTextView email;
    Button registerButton;
    boolean passwordValid = false;
    boolean emailValid = false;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        email = findViewById(R.id.email);
        registerButton = findViewById(R.id.registerButton);


        Spinner spinner = findViewById(R.id.status_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        TextView back2Login = findViewById(R.id.helpTextView);
        String text = "Already have an account? Login now";
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan color = new ForegroundColorSpan(Color.YELLOW);


        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);

            }
        };
        ss.setSpan(clickableSpan, 25, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(color,25,34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        back2Login.setText(ss);
        back2Login.setMovementMethod(LinkMovementMethod.getInstance());

        confirm_password.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strPass1 = password.getText().toString();
                String strPass2 = confirm_password.getText().toString();
                if (strPass1.equals(strPass2)) {
                    passwordValid = true;
                } else {
                    confirm_password.setError("passwords do not match!");
                }

            }
        });

        email.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (email.getText().toString().trim().matches(emailPattern)) {
                    emailValid = true;
                } else{
                    email.setError("invalid email address");
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                if (TextUtils.isEmpty(username.getText())) {
                    username.setError("username is required!");
                } else if (TextUtils.isEmpty(email.getText())) {
                    email.setError("email is required!");
                } else if (TextUtils.isEmpty(password.getText())) {
                    password.setError("password is required!");
                } else if (TextUtils.isEmpty(confirm_password.getText())) {
                    confirm_password.setError("confirmation required!");
                } else if(!passwordValid) {
                    confirm_password.setError("passwords do not match!");
                } else if(!emailValid) {
                    email.setError("invalid email address!");
                } else {
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }
            }
            });
        }
}
