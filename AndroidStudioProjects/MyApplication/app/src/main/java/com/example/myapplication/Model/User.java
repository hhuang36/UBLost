package com.example.myapplication.Model;

public class User {

    private String username;
    private String password;
    private String email;

    public User(){

    }

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

}
