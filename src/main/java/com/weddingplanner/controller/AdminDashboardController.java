package com.weddingplanner.controller;

import com.weddingplanner.service.BookingService;
import com.weddingplanner.service.EventService;
import com.weddingplanner.service.PaymentService;
import com.weddingplanner.service.UserService;
import com.weddingplanner.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminDashboardController {
    private final UserService userService;
    private final EventService eventService;
    private final VendorService vendorService;
    private final BookingService bookingService;
    private final PaymentService paymentService;

    public AdminDashboardController(UserService userService, EventService eventService, VendorService vendorService, BookingService bookingService, PaymentService paymentService) {
        this.userService = userService;
        this.eventService = eventService;
        this.vendorService = vendorService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(HttpSession session, Model model) {
        requireAdmin(session);
        model.addAttribute("users", userService.findAllCustomers());
        model.addAttribute("events", eventService.findAll());
        model.addAttribute("vendors", vendorService.findAll());
        model.addAttribute("bookings", bookingService.findAll());
        model.addAttribute("payments", paymentService.findAll());
        model.addAttribute("totalRevenue", paymentService.totalRevenue());
        model.addAttribute("mostBookedVendorId", bookingService.mostBookedVendorId());
        return "admin/dashboard";
    }

    private void requireAdmin(HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("role"))) {
            throw new IllegalStateException("Admin login required");
        }
    }
}
