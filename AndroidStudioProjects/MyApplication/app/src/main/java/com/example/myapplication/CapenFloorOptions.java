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
                    //Toast.makeText(CapenFloorOptions.this, "Testing", Toast.LENGTH_SHORT).show();
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
