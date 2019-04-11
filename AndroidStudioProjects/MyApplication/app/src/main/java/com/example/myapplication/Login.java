package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;
    private FirebaseAuth mAuth;

    ImageView UBLostLogo;
    ScrollView scrollView;
    TextView UBLostTextView;
    TextView helpTextView;
    AutoCompleteTextView emailAddr;
    AutoCompleteTextView password;
    RadioButton radioButton;
    Button loginButton;
    Button registerButton;

    //security mechanism variables
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //UBLostLogo = findViewById(R.id.UBLostLogo);
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

        //login button functionality - database traversal to be implemented 03/28
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddr.getText().toString();
                final String pass = password.getText().toString();

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
                                    Intent loggedIn = new Intent(Login.this, SplashScreen.class);
                                    startActivity(loggedIn);
                                    finish();
                                }
                            }
                        });
            }
        });
        //register button functionality -- TO BE IMPLEMENTED 03/28
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
