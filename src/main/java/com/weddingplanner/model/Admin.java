package com.weddingplanner.model;

public class Admin extends User {
    private String department;

    public Admin() {
        setRole("ADMIN");
    }

    public Admin(String id, String name, String email, String password, String phone, String department) {
        super(id, name, email, password, phone, "ADMIN");
        this.department = department;
    }

    @Override
    public boolean authenticate(String email, String password) {
        return super.authenticate(email, password) && "ADMIN".equals(getRole());
    }

    @Override
    public String display() {
        return "Admin: " + getName() + " - " + department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
