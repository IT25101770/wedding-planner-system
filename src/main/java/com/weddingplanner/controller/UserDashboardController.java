package com.weddingplanner.controller;

import com.weddingplanner.model.Customer;
import com.weddingplanner.service.BookingService;
import com.weddingplanner.service.EventService;
import com.weddingplanner.service.PaymentService;
import com.weddingplanner.service.UserService;
import com.weddingplanner.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserDashboardController {
    private final UserService userService;
    private final EventService eventService;
    private final VendorService vendorService;
    private final BookingService bookingService;
    private final PaymentService paymentService;

    public UserDashboardController(UserService userService, EventService eventService, VendorService vendorService, BookingService bookingService, PaymentService paymentService) {
        this.userService = userService;
        this.eventService = eventService;
        this.vendorService = vendorService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    @GetMapping("/user/dashboard")
    public String dashboard(HttpSession session, Model model) {
        String customerId = requireCustomer(session);
        model.addAttribute("events", eventService.findByCustomer(customerId));
        model.addAttribute("vendors", vendorService.findAll());
        model.addAttribute("bookings", bookingService.findByCustomer(customerId));
        model.addAttribute("payments", paymentService.findByCustomer(customerId));
        return "user/dashboard";
    }

    @GetMapping("/user/profile")
    public String profile(HttpSession session, Model model) {
        String customerId = requireCustomer(session);
        model.addAttribute("customer", userService.findCustomerById(customerId).orElse(new Customer()));
        return "user/profile";
    }

    @PostMapping("/user/profile")
    public String updateProfile(@ModelAttribute Customer customer, HttpSession session) {
        requireCustomer(session);
        customer.setId((String) session.getAttribute("userId"));
        customer.setRole("CUSTOMER");
        userService.updateCustomer(customer);
        session.setAttribute("userName", customer.getName());
        return "redirect:/user/profile";
    }

    @PostMapping("/user/delete")
    public String deleteAccount(HttpSession session) {
        String customerId = requireCustomer(session);
        userService.deleteCustomer(customerId);
        session.invalidate();
        return "redirect:/";
    }

    private String requireCustomer(HttpSession session) {
        if (!"CUSTOMER".equals(session.getAttribute("role"))) {
            throw new IllegalStateException("Customer login required");
        }
        return (String) session.getAttribute("userId");
    }
}
