package com.weddingplanner.model;

import java.util.List;

public class Budget implements Payable {
    private String customerId;
    private double plannedAmount;
    private List<Payment> payments;

    public Budget(String customerId, double plannedAmount, List<Payment> payments) {
        this.customerId = customerId;
        this.plannedAmount = plannedAmount;
        this.payments = payments;
    }

    @Override
    public double calculateTotal() {
        return payments.stream().mapToDouble(Payment::calculateTotal).sum();
    }

    public double remainingAmount() {
        return plannedAmount - calculateTotal();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPlannedAmount() {
        return plannedAmount;
    }

    public void setPlannedAmount(double plannedAmount) {
        this.plannedAmount = plannedAmount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
