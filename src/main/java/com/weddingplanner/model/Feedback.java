package com.weddingplanner.model;

public class Feedback {
    private String id;
    private String customerId;
    private String name;
    private String email;
    private int rating;
    private String message;
    private String status;
    private String submittedDate;

    public Feedback() {
    }

    public Feedback(String id, String customerId, String name, String email, int rating, String message, String status, String submittedDate) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.message = message;
        this.status = status;
        this.submittedDate = submittedDate;
    }

    public String getDisplayText() {
        return rating + " stars from " + name + " - " + message;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }
}
