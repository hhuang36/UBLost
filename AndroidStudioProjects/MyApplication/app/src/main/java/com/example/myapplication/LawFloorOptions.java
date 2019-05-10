package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LawFloorOptions extends AppCompatActivity {
    ListView search_law;
    ArrayAdapter<String> adapter;

    String[] lawFloorButtons = new String[]{"Floor 2", "Floor 3", "Floor 4", "Floor 5", "Floor 6","Floor 7" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_floor_options);

        search_law = findViewById(R.id.search_law_floors);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lawFloorButtons);
        search_law.setAdapter(adapter);
        search_law.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(lawFloorButtons[position].equals("Floor 2")) {
                    Intent intent = new Intent(LawFloorOptions.this, LawFloor2Plan.class);
                    startActivity(intent);
                } else if(lawFloorButtons[position].equals("Floor 3")){
                    Intent intent = new Intent(LawFloorOptions.this, LawFloor3Plan.class);
                    startActivity(intent);
                } else if(lawFloorButtons[position].equals("Floor 4")){
                    Intent intent = new Intent(LawFloorOptions.this, LawFloor4Plan.class);
                    startActivity(intent);
                } else if(lawFloorButtons[position].equals("Floor 5")) {
                    Intent intent = new Intent(LawFloorOptions.this, LawFloor5Plan.class);
                    startActivity(intent);
                } else if(lawFloorButtons[position].equals("Floor 6")) {
                    Intent intent = new Intent(LawFloorOptions.this, LawFloor6Plan.class);
                    startActivity(intent);
                } else if(lawFloorButtons[position].equals("Floor 7")) {
                    Intent intent = new Intent(LawFloorOptions.this, LawFloor7Plan.class);
                    startActivity(intent);
                }
            }
        });

    }
}


