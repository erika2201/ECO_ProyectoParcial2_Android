package com.example.eco_proyectoparcial2_android;

public class User {
    private String id;
    private String name;
    private String user;
    private String password;

    public User() {}

    public User(String id, String name, String user, String password) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
