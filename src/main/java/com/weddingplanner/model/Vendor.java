package com.weddingplanner.model;

public abstract class Vendor {
    private String id;
    private String name;
    private String category;
    private String phone;
    private String location;
    private double packagePrice;
    private boolean available;

    public Vendor() {
    }

    public Vendor(String id, String name, String category, String phone, String location, double packagePrice, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.phone = phone;
        this.location = location;
        this.packagePrice = packagePrice;
        this.available = available;
    }

    public abstract String getPackageDescription();

    public double calculateFinalPrice(double discountPercent) {
        return packagePrice - (packagePrice * discountPercent / 100.0);
    }

    public String display() {
        return name + " - " + category + " - Rs. " + packagePrice;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
