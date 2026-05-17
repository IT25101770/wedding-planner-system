package com.weddingplanner.model;

public class Customer extends User {
    private String address;

    public Customer() {
        setRole("CUSTOMER");
    }

    public Customer(String id, String name, String email, String password, String phone, String address) {
        super(id, name, email, password, phone, "CUSTOMER");
        this.address = address;
    }

    @Override
    public String display() {
        return "Customer: " + getName() + " - " + getEmail();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}