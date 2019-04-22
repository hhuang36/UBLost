package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.CheckBox;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;






public class Login extends AppCompatActivity {

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;
    private FirebaseAuth mAuth;

    ScrollView scrollView;
    TextView UBLostTextView;
    TextView helpTextView;
    AutoCompleteTextView emailAddr;
    AutoCompleteTextView password;
    RadioButton radioButton;
    Button loginButton;
    Button registerButton;
    private String saveEmail, savePassword;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    //security mechanism variables
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        scrollView = findViewById(R.id.scrollView);
        UBLostTextView = findViewById(R.id.UBlostTextView);
        helpTextView = findViewById(R.id.helpTextView);
        emailAddr = findViewById(R.id.email);
        password = findViewById(R.id.password);
        radioButton = findViewById(R.id.radioButton);
        loginButton = findViewById(R.id.loginButton);
        registerButton = this.findViewById(R.id.registerButton);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();
        saveLoginCheckBox = findViewById(R.id.rememberMe);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            emailAddr.setText(loginPreferences.getString("email", ""));
            password.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddr.getText().toString();
                final String pass = password.getText().toString();

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(emailAddr.getWindowToken(), 0);

                saveEmail = emailAddr.getText().toString();
                savePassword = password.getText().toString();

                if (saveLoginCheckBox.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("email", saveEmail);
                    loginPrefsEditor.putString("password", savePassword);
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }

                if (TextUtils.isEmpty(email)) {
                    emailAddr.setError("Enter email!");
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    password.setError("Enter password!");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (pass.length() < 6) {
                                        password.setError("Password must be greater than 6 characters!");
                                    } else {
                                        Toast.makeText(Login.this, "Incorrect Credentials!", Toast.LENGTH_LONG).show();
                                        counter--;
                                    }
                                    if (counter == 0)
                                        loginButton.setEnabled(false);
                                } else {
                                    Intent loggedIn = new Intent(Login.this, HomeScreen.class);
                                    startActivity(loggedIn);
                                    finish();
                                }
                            }
                        });
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });

        getWindow().setBackgroundDrawableResource(R.drawable.darkenbackground2);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
}
