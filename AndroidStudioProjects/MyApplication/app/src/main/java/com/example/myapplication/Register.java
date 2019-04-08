package com.example.myapplication;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    //database
    private FirebaseDatabase database;
    private DatabaseReference users;

//    private FirebaseAuth mAuth;

    AutoCompleteTextView editTextUsername;
    AutoCompleteTextView editTextPassword;
    AutoCompleteTextView confirm_password;
    AutoCompleteTextView editTextEmail;
    Button registerButton;
    RadioButton terms;
    boolean passwordValid = false;
    boolean emailValid = false;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

//        progressDialog = new ProgressDialog (this);
//        mAuth = FirebaseAuth.getInstance();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        editTextEmail = findViewById(R.id.email);
        registerButton = findViewById(R.id.registerButton);
        terms = findViewById(R.id.radioButton);


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
                String strPass1 = editTextPassword.getText().toString();
                String strPass2 = confirm_password.getText().toString();
                if (strPass1.equals(strPass2)) {
                    passwordValid = true;
                } else {
                    confirm_password.setError("passwords do not match!");
                }

            }
        });

        editTextEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (editTextEmail.getText().toString().trim().matches(emailPattern)) {
                    emailValid = true;
                } else{
                    editTextEmail.setError("invalid editTextEmail address");
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                    if (TextUtils.isEmpty(editTextUsername.getText())) {
                    editTextUsername.setError("editTextUsername is required!");
                } else if (TextUtils.isEmpty(editTextEmail.getText())) {
                    editTextEmail.setError("editTextEmail is required!");
                } else if (TextUtils.isEmpty(editTextPassword.getText())) {
                    editTextPassword.setError("editTextPassword is required!");
                } else if (TextUtils.isEmpty(confirm_password.getText())) {
                    confirm_password.setError("confirmation required!");
                } else if(!passwordValid) {
                    confirm_password.setError("passwords do not match!");
                } else if(!emailValid) {
                    editTextEmail.setError("invalid editTextEmail address!");
                }else if(!terms.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Please accept Terms and Conditions", Toast.LENGTH_SHORT).show();
                } else{
                        final User user = new User(editTextUsername.getText().toString(),
                                editTextPassword.getText().toString(),
                                editTextEmail.getText().toString());
                        users.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.child(user.getUsername()).exists())
                                    Toast.makeText(Register.this, "This Username already exists! Please choose another", Toast.LENGTH_SHORT).show();
                                else {
                                    users.child(user.getUsername()).setValue(user);
                                    Toast.makeText(Register.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
//                    String email = editTextEmail.getText().toString().trim();
//                    String password = editTextPassword.getText().toString().trim();
//                    progressDialog.setMessage("Registering User...");
//                    progressDialog.show();
//
//                    mAuth.createUserWithEmailAndPassword(email,password);
//                    Toast.makeText(getApplicationContext(), "Registration Success!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }

                }
            });

        }
}
