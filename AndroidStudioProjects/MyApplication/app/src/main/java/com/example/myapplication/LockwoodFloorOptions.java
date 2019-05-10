package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LockwoodFloorOptions extends AppCompatActivity {
    ListView search_lockwood;
    ArrayAdapter<String> adapter;

    String[] lockwoodFloorButtons = new String[]{"Basement", "Floor 1", "Floor 2", "Floor 3", "Floor 4", "Floor 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockwood_floor_options);

        search_lockwood = findViewById(R.id.search_lockwood_floors);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lockwoodFloorButtons);
        search_lockwood.setAdapter(adapter);
        search_lockwood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(lockwoodFloorButtons[position].equals("Basement")) {
                    Intent intent = new Intent(LockwoodFloorOptions.this, LockwoodBPlan.class);
                    startActivity(intent);
                } else if(lockwoodFloorButtons[position].equals("Floor 1")){
                    Intent intent = new Intent(LockwoodFloorOptions.this, LockwoodFloor1Plan.class);
                    startActivity(intent);
                } else if(lockwoodFloorButtons[position].equals("Floor 2")){
                    Intent intent = new Intent(LockwoodFloorOptions.this, LockwoodFloor2Plan.class);
                    startActivity(intent);
                } else if(lockwoodFloorButtons[position].equals("Floor 3")) {
                    Intent intent = new Intent(LockwoodFloorOptions.this, LockwoodFloor3Plan.class);
                    startActivity(intent);
                } else if(lockwoodFloorButtons[position].equals("Floor 4")) {
                    Intent intent = new Intent(LockwoodFloorOptions.this, LockwoodFloor4Plan.class);
                    startActivity(intent);
                } else if(lockwoodFloorButtons[position].equals("Floor 5")) {
                    Intent intent = new Intent(LockwoodFloorOptions.this, LockwoodFloor5Plan.class);
                    startActivity(intent);
                }
            }
        });

    }
}


