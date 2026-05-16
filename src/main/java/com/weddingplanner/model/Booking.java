package com.weddingplanner.model;

public class Booking {
    private String id;
    private String customerId;
    private String eventId;
    private String vendorId;
    private String bookingDate;
    private String status;

    public Booking() {
    }

    public Booking(String id, String customerId, String eventId, String vendorId, String bookingDate, String status) {
        this.id = id;
        this.customerId = customerId;
        this.eventId = eventId;
        this.vendorId = vendorId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public boolean isConfirmed() {
        return "Confirmed".equalsIgnoreCase(status);
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
