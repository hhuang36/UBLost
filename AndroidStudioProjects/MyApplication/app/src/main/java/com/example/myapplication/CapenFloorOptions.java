package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CapenFloorOptions extends AppCompatActivity {

    ListView search_capen;
    ArrayAdapter<String> adapter;

    String[] capenFloorButtons = new String[]{"Floor 2", "Floor 3", "Floor 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capen_floor_options);

        search_capen = findViewById(R.id.search_capen_floors);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, capenFloorButtons);
        search_capen.setAdapter(adapter);
        search_capen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(capenFloorButtons[position].equals("Floor 2")){
                    Intent intent = new Intent(CapenFloorOptions.this, CapenFloor2Plan.class);
                    startActivity(intent);
                } else if(capenFloorButtons[position].equals("Floor 3")){
                    Intent intent = new Intent(CapenFloorOptions.this, CapenFloor3Plan.class);
                    startActivity(intent);
                } else if(capenFloorButtons[position].equals("Floor 4")){
                    Intent intent = new Intent(CapenFloorOptions.this, CapenFloor4Plan.class);
                    startActivity(intent);
                }
            }
        });

    }
}
