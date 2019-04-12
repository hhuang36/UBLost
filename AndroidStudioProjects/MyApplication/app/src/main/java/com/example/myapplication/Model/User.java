package com.example.myapplication.Model;

public class User {

    private String password;
    private String email;
    private String status;

    public User(String password, String email, String status){
        this.password = password;
        this.email = email;
        this.status = status;
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
