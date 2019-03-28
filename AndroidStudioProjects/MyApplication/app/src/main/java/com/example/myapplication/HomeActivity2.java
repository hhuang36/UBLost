package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

public class HomeActivity2 extends AppCompatActivity {

    ListView search_building;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        search_building = findViewById(R.id.search_building);

        ArrayList<String> arrayBuildings = new ArrayList<String>();
        arrayBuildings.addAll(Arrays.asList(getResources().getStringArray(R.array.my_buildings)));

        adapter = new ArrayAdapter<String>(
                HomeActivity2.this,
                android.R.layout.simple_list_item_1,
                arrayBuildings
        );

        search_building.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_building_menu, menu);
        MenuItem item = menu.findItem(R.id.search_building);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
