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

    String lockwoodFloorButtons[] = new String [] {"Basement", "Floor 1", "Floor 2", "Floor 3", "Floor 4", "Floor 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockwood_floor_options);

        search_lockwood = findViewById(R.id.search_lockwood_floors);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lockwoodFloorButtons);
        search_lockwood.setAdapter(adapter);
        search_lockwood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(lockwoodFloorButtons[position] == "Basement"){
                    // TODO: Add floor plans for Lockwood
                    openUnderConstruction();
                } else if(lockwoodFloorButtons[position].equals("Floor 1")){
                    openUnderConstruction();
                } else if(lockwoodFloorButtons[position].equals("Floor 2")){
                    openUnderConstruction();
                } else if(lockwoodFloorButtons[position].equals("Floor 3")) {
                    openUnderConstruction();
                } else if(lockwoodFloorButtons[position].equals("Floor 4")) {
                    openUnderConstruction();
                } else if(lockwoodFloorButtons[position].equals("Floor 5")) {
                    openUnderConstruction();
                }
            }
        });

    }

    public void openUnderConstruction(){
        Intent intent = new Intent(LockwoodFloorOptions.this, UnderConstructionActivity.class);
        startActivity(intent);
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
