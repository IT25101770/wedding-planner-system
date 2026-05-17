package com.weddingplanner.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String role;

    public User() {
    }

    public User(String id, String name, String email, String password, String phone, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public boolean authenticate(String email, String password) {
        return this.email != null && this.email.equalsIgnoreCase(email) && this.password != null && this.password.equals(password);
    }

    public String display() {
        return name + " (" + role + ")";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}