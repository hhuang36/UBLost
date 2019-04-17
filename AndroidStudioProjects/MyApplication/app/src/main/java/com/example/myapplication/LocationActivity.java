package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class LocationActivity extends AppCompatActivity {

    ListView search_location;
    ArrayAdapter<String> adapter;
    TextView LocationTextView;
    String buildingButtons[] = new String [] {"Capen Library", "Lockwood Library", "Norton Hall", "Davis Hall", "Music Library", "Natural Science Complex", "Student Union", "Knox Hall"};
    SearchView searchView;
    Button getCurrentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        search_location = findViewById(R.id.search_location);

        ArrayList<String> arrayLocations = new ArrayList<String>();
        arrayLocations.addAll(Arrays.asList(getResources().getStringArray(R.array.my_locations)));

        adapter = new ArrayAdapter<String>(
                LocationActivity.this,
                android.R.layout.simple_list_item_1,
                arrayLocations
        );

        search_location.setAdapter(adapter);

        search_location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(buildingButtons[position] == "Capen Library"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                } else if(buildingButtons[position] == "Lockwood Library"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                } else if(buildingButtons[position] == "Norton Hall"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                } else if(buildingButtons[position] == "Davis Hall"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                } else if(buildingButtons[position] == "Music Library"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                } else if(buildingButtons[position] == "Natural Science Complex"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                } else if(buildingButtons[position] == "Student Union"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                } else if(buildingButtons[position] == "Knox Hall"){
                    Intent intent = new Intent(LocationActivity.this, CapenFloor1Plan.class);
                    startActivity(intent);
                }
            }
        });

    }
}
