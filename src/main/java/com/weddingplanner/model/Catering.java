package com.weddingplanner.model;

public class Catering extends Vendor {
    public Catering() {
        setCategory("Catering");
    }

    public Catering(String id, String name, String phone, String location, double packagePrice, boolean available) {
        super(id, name, "Catering", phone, location, packagePrice, available);
    }

    @Override
    public String getPackageDescription() {
        return "Buffet menu package calculated per event";
    }
}
