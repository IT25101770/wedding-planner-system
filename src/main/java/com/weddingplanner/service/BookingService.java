package com.weddingplanner.service;

import com.weddingplanner.model.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private static final String FILE = "bookings.txt";
    private final FileStorageService storage;

    public BookingService(FileStorageService storage) {
        this.storage = storage;
    }

    public Booking add(Booking booking) {
        booking.setId(storage.nextId("BKG"));
        booking.setBookingDate(LocalDate.now().toString());
        if (booking.getStatus() == null || booking.getStatus().isEmpty()) {
            booking.setStatus("Pending");
        }
        List<Booking> bookings = findAll();
        bookings.add(booking);
        save(bookings);
        return booking;
    }

    public List<Booking> findAll() {
        return storage.readRecords(FILE).stream().map(this::toBooking).collect(Collectors.toList());
    }

    public List<Booking> findByCustomer(String customerId) {
        return findAll().stream().filter(booking -> booking.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }

    public Optional<Booking> findById(String id) {
        return findAll().stream().filter(booking -> booking.getId().equals(id)).findFirst();
    }

    public void updateStatus(String id, String status) {
        save(findAll().stream().peek(booking -> {
            if (booking.getId().equals(id)) {
                booking.setStatus(status);
            }
        }).collect(Collectors.toList()));
    }

    public void delete(String id) {
        save(findAll().stream().filter(booking -> !booking.getId().equals(id)).collect(Collectors.toList()));
    }

    public String mostBookedVendorId() {
        return findAll().stream()
                .collect(Collectors.groupingBy(Booking::getVendorId, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue()))
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

    private void save(List<Booking> bookings) {
        storage.writeRecords(FILE, bookings.stream().map(this::fromBooking).collect(Collectors.toList()));
    }

    private Booking toBooking(String[] parts) {
        return new Booking(value(parts, 0), value(parts, 1), value(parts, 2), value(parts, 3), value(parts, 4), value(parts, 5));
    }

    private String fromBooking(Booking booking) {
        return String.join("|", booking.getId(), booking.getCustomerId(), booking.getEventId(), booking.getVendorId(), booking.getBookingDate(), booking.getStatus());
    }

    private String value(String[] parts, int index) {
        return index < parts.length ? parts[index] : "";
    }
}
