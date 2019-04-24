package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MusicFloorOptions extends AppCompatActivity {

    ListView search_music;
    ArrayAdapter<String> adapter;

    String[] musicFloorButtons = new String[]{"Floor 1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_floor_options);

        search_music = findViewById(R.id.search_music_floors);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, musicFloorButtons);
        search_music.setAdapter(adapter);
        search_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (musicFloorButtons[position].equals("Floor 1"))
                    // TODO: Add floor plans for Music Library
                    openUnderConstruction();
            }
        });
    }

    public void openUnderConstruction(){
        Intent intent = new Intent(MusicFloorOptions.this, UnderConstructionActivity.class);
        startActivity(intent);
    }

}
