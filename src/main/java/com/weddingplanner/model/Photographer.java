package com.weddingplanner.model;

public class Photographer extends Vendor {
    public Photographer() {
        setCategory("Photographer");
    }

    public Photographer(String id, String name, String phone, String location, double packagePrice, boolean available) {
        super(id, name, "Photographer", phone, location, packagePrice, available);
    }

    @Override
    public String getPackageDescription() {
        return "Full-day photography with edited album";
    }
}
