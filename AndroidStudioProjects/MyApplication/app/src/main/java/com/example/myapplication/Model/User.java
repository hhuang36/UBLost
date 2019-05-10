package com.example.myapplication.Model;

import java.util.List;

public class User {

    private String password;
    private String email;
    private String status;
    private List friends;

    public User(String password, String email, String status, List friends){
        this.password = password;
        this.email = email;
        this.status = status;
        this.friends = friends;
    }

    public List getFriends() {
        return friends;
    }
    public void addFriend(String user) {
        friends.add(user);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword() {
        this.password = password;
    }

    public String getEmail() { return email; }
    public void setEmail() { this.email = email; }

    public String getStatus() { return status; }
    public void setStatus() { this.status = status; }

}
