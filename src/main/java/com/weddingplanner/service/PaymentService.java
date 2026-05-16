package com.weddingplanner.service;

import com.weddingplanner.model.Payment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private static final String FILE = "payments.txt";
    private final FileStorageService storage;

    public PaymentService(FileStorageService storage) {
        this.storage = storage;
    }

    public Payment add(Payment payment) {
        payment.setId(storage.nextId("PAY"));
        payment.setPaidDate(LocalDate.now().toString());
        payment.setStatus("Paid");
        List<Payment> payments = findAll();
        payments.add(payment);
        save(payments);
        return payment;
    }

    public List<Payment> findAll() {
        return storage.readRecords(FILE).stream().map(this::toPayment).collect(Collectors.toList());
    }

    public List<Payment> findByCustomer(String customerId) {
        return findAll().stream().filter(payment -> payment.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }

    public Optional<Payment> findById(String id) {
        return findAll().stream().filter(payment -> payment.getId().equals(id)).findFirst();
    }

    public void update(Payment updated) {
        findById(updated.getId()).ifPresent(existing -> {
            updated.setPaidDate(existing.getPaidDate());
            updated.setStatus(existing.getStatus());
        });
        save(findAll().stream().map(payment -> payment.getId().equals(updated.getId()) ? updated : payment).collect(Collectors.toList()));
    }

    public void delete(String id) {
        save(findAll().stream().filter(payment -> !payment.getId().equals(id)).collect(Collectors.toList()));
    }

    public double totalRevenue() {
        return findAll().stream().filter(payment -> "Paid".equalsIgnoreCase(payment.getStatus())).mapToDouble(Payment::calculateTotal).sum();
    }

    private void save(List<Payment> payments) {
        storage.writeRecords(FILE, payments.stream().map(this::fromPayment).collect(Collectors.toList()));
    }

    private Payment toPayment(String[] parts) {
        return new Payment(value(parts, 0), value(parts, 1), value(parts, 2), parseDouble(value(parts, 3)), parseDouble(value(parts, 4)), value(parts, 5), value(parts, 6));
    }

    private String fromPayment(Payment payment) {
        return String.join("|", payment.getId(), payment.getCustomerId(), payment.getBookingId(), String.valueOf(payment.getAmount()), String.valueOf(payment.getDiscountPercent()), payment.getStatus(), payment.getPaidDate());
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private String value(String[] parts, int index) {
        return index < parts.length ? parts[index] : "";
    }
}
