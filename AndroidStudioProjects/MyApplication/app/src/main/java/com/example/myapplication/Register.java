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
import android.view.View;
import android.view.WindowManager;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        Spinner spinner = (Spinner) findViewById(R.id.status_spinner);
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
            public void onClick(View widget) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 25, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(color,25,34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        back2Login.setText(ss);
        back2Login.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
