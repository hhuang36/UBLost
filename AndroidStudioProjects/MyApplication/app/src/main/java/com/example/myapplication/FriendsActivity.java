package com.example.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.Model.Friends;
import com.example.myapplication.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    //database
    private FirebaseDatabase database;
    private DatabaseReference friends;
    private DatabaseReference users;
    private FirebaseAuth mAuth;

    ListView listFriends;
    ArrayAdapter<String> adapter;
    ArrayList<String> list_Friends = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        listFriends = (ListView) findViewById(R.id.listFriends);
        //database
        database = FirebaseDatabase.getInstance();
        friends = database.getReference("Friends");
        users = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        final String currentUser = mAuth.getCurrentUser().getUid();

        //show friends
        friends.child(currentUser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dbListFriends: dataSnapshot.getChildren()){
                    //get UID of riends
                    String friendUID = dbListFriends.getKey().toString();
                    //search for UID in Users
                    users.child(friendUID).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot credentials: dataSnapshot.getChildren()){
                                if(credentials.getKey().equalsIgnoreCase("email")) {
                                    String myFriend = credentials.getValue().toString();
                                    myFriend = myFriend.replace("@gmail.com", "");
                                    //add friends to list
                                    list_Friends.add(myFriend);
                                    adapter = new ArrayAdapter<>(FriendsActivity.this, android.R.layout.simple_list_item_1, list_Friends);
                                    listFriends.setAdapter(adapter);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
