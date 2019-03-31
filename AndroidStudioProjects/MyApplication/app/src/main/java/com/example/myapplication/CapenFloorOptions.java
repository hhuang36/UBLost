package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

public class CapenFloorOptions extends AppCompatActivity {

    ListView search_capen;
    ArrayAdapter<String> adapter;

    String capenFloorButtons[] = new String [] {"Floor 1", "Floor 2", "Floor 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capen_floor_options);

        search_capen = findViewById(R.id.search_capen_floors);

//        ArrayList<String> arrayBuildings = new ArrayList<String>();
//        arrayBuildings.addAll(Arrays.asList(getResources().getStringArray(R.array.search_capen_floors)));
//
//        adapter = new ArrayAdapter<String>(
//                CapenFloorOptions.this,
//                android.R.layout.simple_list_item_1,
//                arrayBuildings
//        );
//        search_capen.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, capenFloorButtons);
        search_capen.setAdapter(adapter);
        search_capen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(capenFloorButtons[position] == "Floor 1"){
                    Toast.makeText(CapenFloorOptions.this, "Testing", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(CapenFloorOptions.this, capenFloor1Plan.class);
//                    startActivity(intent);
                } else if(capenFloorButtons[position] == "Floor 2"){
//                    Intent intent = new Intent(CapenFloorOptions.this, capenFloor2Plan.class);
//                    startActivity(intent);
                } else if(capenFloorButtons[position] == "Floor 3"){
//                    Intent intent = new Intent(CapenFloorOptions.this, capenFloor3Plan.class);
//                    startActivity(intent);
                }
            }
        });

    }

//    listview.setOnItemClickListener(new OnItemClickListener(){
//        @Override
//        public void onItemClick(AdapterView<?>adapter,View v, int position){
//            ItemClicked item = adapter.getItemAtPosition(position);
//
//            Intent intent = new Intent(Activity.this,destinationActivity.class);
//            //based on item add info to intent
//            startActivity(intent);
//        }
//    });
//    in your adapter's getItem you write
//
//    public ItemClicked getItem(int position){
//        return items.get(position);
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_capen_floors, menu);
//        MenuItem item = menu.findItem(R.id.search_capen_floors);
//        SearchView searchView = (SearchView) item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//    }
}
