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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.myapplication.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity implements View.OnClickListener {

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;
    private FirebaseAuth mAuth;

    AutoCompleteTextView editTextUsername;
    AutoCompleteTextView editTextPassword;
    AutoCompleteTextView confirm_password;
    AutoCompleteTextView editTextEmail;
    RadioButton terms;
    boolean passwordValid = false;
    boolean emailValid = false;
    boolean userValid = false;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Spinner spinner;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        findViewById(R.id.registerButton).setOnClickListener(this);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        editTextEmail = findViewById(R.id.email);
        terms = findViewById(R.id.radioButton);
        spinner = findViewById(R.id.status_spinner);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Creating link text to go back to Login page
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
        ss.setSpan(color, 25, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        back2Login.setText(ss);
        back2Login.setMovementMethod(LinkMovementMethod.getInstance());

        // username verification (no duplicates)
        editTextUsername.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                    }

                                                    @Override
                                                    public void afterTextChanged(Editable s) {
                                                        users.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                if (dataSnapshot.child(editTextUsername.getText().toString().trim()).exists()) {
                                                                    editTextUsername.setError("Username already exists");
                                                                    userValid = false;
                                                                } else
                                                                    userValid = true;
                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                                            }
                                                        });
                                                    }
                                                });

        // Matching password verification
        confirm_password.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                    }

                                                    @Override
                                                    public void afterTextChanged(Editable s) {
                                                        String strPass1 = editTextPassword.getText().toString();
                                                        String strPass2 = confirm_password.getText().toString();
                                                        if (strPass1.equals(strPass2)) {
                                                            passwordValid = true;
                                                        } else {
                                                            confirm_password.setError("Passwords do not match!");
                                                        }
                                                    }
                                                });

        // Email format verification
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editTextEmail.getText().toString().trim().matches(emailPattern)) {
                    emailValid = true;
                } else {
                    editTextEmail.setError("Invalid email address");
                }
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if (mAuth.getCurrentUser() != null) {
            //handle the already login user
        }
    }

    public void registerUser() {
        status = spinner.getSelectedItem().toString();
        final String username = editTextUsername.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String password_again = confirm_password.getText().toString().trim();

        if (username.isEmpty()) {
            editTextUsername.setError("Username is required!");
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required!");
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            return;
        }

        if (password_again.isEmpty()) {
            confirm_password.setError("Confirmation required!");
            return;
        }

        if (!userValid) {
            editTextUsername.setError("Username already exists!");
            return;
        }

        if (!passwordValid) {
            confirm_password.setError("Passwords do not match!");
            return;
        }

        if (!emailValid) {
            editTextEmail.setError("Invalid email address!");
            return;
        }

        if (!terms.isChecked()) {
            Toast.makeText(getApplicationContext(), "Please accept Terms and Conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userValid) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                final User user = new User(editTextUsername.getText().toString().trim(), password, email, status);

                                users.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.child(user.getUsername()).exists()) {
                                            Toast.makeText(Register.this, "Username already exists!", Toast.LENGTH_LONG).show();
                                        } else {
                                            users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Toast.makeText(Register.this, "Successfully Registered!", Toast.LENGTH_LONG).show();
                                                                Intent intent = new Intent(Register.this, Login.class);
                                                                startActivity(intent);

                                                            } else {
                                                                Toast.makeText(Register.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                                                            }
                                                        }
                                                    });
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                    }
                                });
                            } else {
                                Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    } // end RegisterUser

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerButton:
                registerUser();
                break;
        }
    }
}





