package com.weddingplanner.model;

public class Decoration extends Vendor {
    public Decoration() {
        setCategory("Decoration");
    }

    public Decoration(String id, String name, String phone, String location, double packagePrice, boolean available) {
        super(id, name, "Decoration", phone, location, packagePrice, available);
    }

    @Override
    public String getPackageDescription() {
        return "Stage, floral, table and theme decoration";
    }
}
