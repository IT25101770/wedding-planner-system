package com.weddingplanner.model;

public class MusicBand extends Vendor {
    public MusicBand() {
        setCategory("MusicBand");
    }

    public MusicBand(String id, String name, String phone, String location, double packagePrice, boolean available) {
        super(id, name, "MusicBand", phone, location, packagePrice, available);
    }

    @Override
    public String getPackageDescription() {
        return "Live band performance and sound setup";
    }
}
