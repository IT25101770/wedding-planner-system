package com.weddingplanner.model;

public class WeddingEvent {
    private String id;
    private String customerId;
    private String date;
    private String venue;
    private int guestCount;
    private String theme;

    public WeddingEvent() {
    }

    public WeddingEvent(String id, String customerId, String date, String venue, int guestCount, String theme) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.venue = venue;
        this.guestCount = guestCount;
        this.theme = theme;
    }

    public String display() {
        return date + " wedding at " + venue + " for " + guestCount + " guests";
    }

    public String getDisplayText() {
        return display();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
