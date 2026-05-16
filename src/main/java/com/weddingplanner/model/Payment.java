package com.weddingplanner.model;

public class Payment implements Payable {
    private String id;
    private String customerId;
    private String bookingId;
    private double amount;
    private double discountPercent;
    private String status;
    private String paidDate;

    public Payment() {
    }

    public Payment(String id, String customerId, String bookingId, double amount, double discountPercent, String status, String paidDate) {
        this.id = id;
        this.customerId = customerId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.discountPercent = discountPercent;
        this.status = status;
        this.paidDate = paidDate;
    }

    @Override
    public double calculateTotal() {
        return amount - (amount * discountPercent / 100.0);
    }

    public double getTotal() {
        return calculateTotal();
    }

    public String invoiceLine() {
        return "Invoice " + id + " | Booking " + bookingId + " | Total Rs. " + calculateTotal();
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

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }
}
