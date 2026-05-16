package com.weddingplanner.config;

import com.weddingplanner.model.Booking;
import com.weddingplanner.model.Customer;
import com.weddingplanner.model.Payment;
import com.weddingplanner.model.Vendor;
import com.weddingplanner.model.WeddingEvent;
import com.weddingplanner.service.BookingService;
import com.weddingplanner.service.EventService;
import com.weddingplanner.service.PaymentService;
import com.weddingplanner.service.UserService;
import com.weddingplanner.service.VendorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final UserService userService;
    private final VendorService vendorService;
    private final EventService eventService;
    private final BookingService bookingService;
    private final PaymentService paymentService;

    public SampleDataLoader(UserService userService, VendorService vendorService, EventService eventService, BookingService bookingService, PaymentService paymentService) {
        this.userService = userService;
        this.vendorService = vendorService;
        this.eventService = eventService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) {
        userService.ensureDefaultAdmin();
        if (userService.findAllCustomers().isEmpty()) {
            Customer customer = userService.registerCustomer(new Customer(null, "Amaya Fernando", "user@wedding.com", "user123", "0711234567", "Colombo"));
            Vendor photographer = vendorService.add(vendorService.createByCategory(null, "Photographer", "Dream Lens Studio", "0771122334", "Colombo", 85000, true));
            Vendor catering = vendorService.add(vendorService.createByCategory(null, "Catering", "Royal Feast Catering", "0774455667", "Colombo", 150000, true));
            WeddingEvent event = eventService.add(new WeddingEvent(null, customer.getId(), "2026-08-15", "Lotus Grand Ballroom", 250, "Elegant White"));
            Booking booking = bookingService.add(new Booking(null, customer.getId(), event.getId(), photographer.getId(), null, "Confirmed"));
            bookingService.add(new Booking(null, customer.getId(), event.getId(), catering.getId(), null, "Pending"));
            paymentService.add(new Payment(null, customer.getId(), booking.getId(), 85000, 10, "Paid", "2026-05-06"));
        }
    }
}
