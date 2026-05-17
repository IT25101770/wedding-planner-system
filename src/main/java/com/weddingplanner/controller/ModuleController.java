package com.weddingplanner.controller;

import com.weddingplanner.model.Booking;
import com.weddingplanner.model.Feedback;
import com.weddingplanner.model.Payment;
import com.weddingplanner.model.Vendor;
import com.weddingplanner.model.WeddingEvent;
import com.weddingplanner.service.BookingService;
import com.weddingplanner.service.EventService;
import com.weddingplanner.service.FeedbackService;
import com.weddingplanner.service.PaymentService;
import com.weddingplanner.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ModuleController {
    private final EventService eventService;
    private final VendorService vendorService;
    private final BookingService bookingService;
    private final PaymentService paymentService;
    private final FeedbackService feedbackService;

    public ModuleController(EventService eventService, VendorService vendorService, BookingService bookingService, PaymentService paymentService, FeedbackService feedbackService) {
        this.eventService = eventService;
        this.vendorService = vendorService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/events")
    public String events(HttpSession session, Model model) {
        requireAuthenticated(session);
        String role = (String) session.getAttribute("role");
        String customerId = (String) session.getAttribute("userId");
        model.addAttribute("events", "ADMIN".equals(role) ? eventService.findAll() : eventService.findByCustomer(customerId));
        return "events/list";
    }

    @GetMapping("/events/new")
    public String eventForm(HttpSession session, Model model) {
        requireCustomer(session);
        model.addAttribute("event", new WeddingEvent());
        return "events/form";
    }

    @PostMapping("/events")
    public String saveEvent(@ModelAttribute WeddingEvent event, HttpSession session) {
        requireAuthenticated(session);
        if (event.getId() == null || event.getId().isEmpty()) {
            requireCustomer(session);
            event.setCustomerId((String) session.getAttribute("userId"));
            eventService.add(event);
        } else {
            eventService.update(event);
        }
        return "redirect:/events";
    }

    @GetMapping("/events/{id}/edit")
    public String editEvent(@PathVariable String id, HttpSession session, Model model) {
        requireAuthenticated(session);
        model.addAttribute("event", eventService.findById(id).orElse(new WeddingEvent()));
        return "events/form";
    }

    @GetMapping("/events/{id}")
    public String eventDetails(@PathVariable String id, HttpSession session, Model model) {
        requireAuthenticated(session);
        model.addAttribute("event", eventService.findById(id).orElse(new WeddingEvent()));
        return "events/detail";
    }

    @PostMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable String id, HttpSession session) {
        requireAuthenticated(session);
        eventService.delete(id);
        return "redirect:/events";
    }

    @GetMapping("/vendors")
    public String vendors(@RequestParam(required = false) String category, @RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("vendors", vendorService.search(category, keyword));
        model.addAttribute("category", category);
        model.addAttribute("keyword", keyword);
        return "vendors/list";
    }

    @GetMapping("/vendors/new")
    public String vendorForm(HttpSession session, Model model) {
        requireAdmin(session);
        model.addAttribute("vendor", vendorService.createByCategory("", "Photographer", "", "", "", 0, true));
        return "vendors/form";
    }

    @PostMapping("/vendors")
    public String saveVendor(@RequestParam(required = false) String id, @RequestParam String name, @RequestParam String category, @RequestParam String phone, @RequestParam String location, @RequestParam double packagePrice, @RequestParam(defaultValue = "false") boolean available, HttpSession session) {
        requireAdmin(session);
        Vendor vendor = vendorService.createByCategory(id, category, name, phone, location, packagePrice, available);
        if (id == null || id.isEmpty()) {
            vendorService.add(vendor);
        } else {
            vendorService.update(vendor);
        }
        return "redirect:/vendors";
    }

    @GetMapping("/vendors/{id}/edit")
    public String editVendor(@PathVariable String id, HttpSession session, Model model) {
        requireAdmin(session);
        model.addAttribute("vendor", vendorService.findById(id).orElse(vendorService.createByCategory("", "Photographer", "", "", "", 0, true)));
        return "vendors/form";
    }

    @GetMapping("/vendors/{id}")
    public String vendorDetails(@PathVariable String id, Model model) {
        model.addAttribute("vendor", vendorService.findById(id).orElse(vendorService.createByCategory("", "Photographer", "", "", "", 0, false)));
        return "vendors/detail";
    }

    @PostMapping("/vendors/{id}/delete")
    public String deleteVendor(@PathVariable String id, HttpSession session) {
        requireAdmin(session);
        vendorService.delete(id);
        return "redirect:/vendors";
    }

    @GetMapping("/bookings")
    public String bookings(HttpSession session, Model model) {
        requireAuthenticated(session);
        String role = (String) session.getAttribute("role");
        String customerId = (String) session.getAttribute("userId");
        model.addAttribute("bookings", "ADMIN".equals(role) ? bookingService.findAll() : bookingService.findByCustomer(customerId));
        model.addAttribute("payments", "ADMIN".equals(role) ? paymentService.findAll() : paymentService.findByCustomer(customerId));
        return "bookings/list";
    }

    @GetMapping("/bookings/new")
    public String bookingForm(@RequestParam(required = false) String vendorId, HttpSession session, Model model) {
        requireCustomer(session);
        String customerId = (String) session.getAttribute("userId");
        Booking booking = new Booking();
        booking.setVendorId(vendorId);
        model.addAttribute("booking", booking);
        model.addAttribute("events", eventService.findByCustomer(customerId));
        model.addAttribute("vendors", vendorService.findAll());
        model.addAttribute("selectedVendorId", vendorId);
        return "bookings/form";
    }

    @PostMapping("/bookings")
    public String saveBooking(@ModelAttribute Booking booking, @RequestParam(required = false) List<String> vendorIds, HttpSession session) {
        requireCustomer(session);
        booking.setCustomerId((String) session.getAttribute("userId"));
        if (vendorIds != null && !vendorIds.isEmpty()) {
            booking.setVendorId(String.join(",", vendorIds));
        }
        Booking saved = bookingService.add(booking);
        return "redirect:/payments/new?bookingId=" + saved.getId();
    }

    @GetMapping("/bookings/{id}")
    public String bookingDetails(@PathVariable String id, HttpSession session, Model model) {
        requireAuthenticated(session);
        model.addAttribute("booking", bookingService.findById(id).orElse(new Booking()));
        return "bookings/detail";
    }

    @PostMapping("/bookings/{id}/status")
    public String status(@PathVariable String id, @RequestParam String status, HttpSession session) {
        requireAdmin(session);
        bookingService.updateStatus(id, status);
        return "redirect:/bookings";
    }

    @PostMapping("/bookings/{id}/delete")
    public String deleteBooking(@PathVariable String id, HttpSession session) {
        requireAuthenticated(session);
        bookingService.delete(id);
        return "redirect:/bookings";
    }

    @GetMapping("/payments")
    public String payments(HttpSession session, Model model) {
        requireAuthenticated(session);
        String role = (String) session.getAttribute("role");
        String customerId = (String) session.getAttribute("userId");
        model.addAttribute("payments", "ADMIN".equals(role) ? paymentService.findAll() : paymentService.findByCustomer(customerId));
        return "payments/list";
    }

    @GetMapping("/payments/new")
    public String paymentForm(@RequestParam(required = false) String bookingId, HttpSession session, Model model) {
        requireCustomer(session);
        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setPaidDate(LocalDate.now().toString());
        bookingService.findById(bookingId).ifPresent(booking -> payment.setAmount(packageTotal(booking.getVendorId())));
        model.addAttribute("payment", payment);
        model.addAttribute("bookings", bookingService.findByCustomer((String) session.getAttribute("userId")));
        model.addAttribute("vendors", vendorService.findAll());
        model.addAttribute("bookingTotals", bookingTotals(bookingService.findByCustomer((String) session.getAttribute("userId"))));
        model.addAttribute("selectedBookingId", bookingId);
        return "payments/form";
    }

    @PostMapping("/payments")
    public String savePayment(@ModelAttribute Payment payment, HttpSession session) {
        requireCustomer(session);
        payment.setCustomerId((String) session.getAttribute("userId"));
        payment.setStatus("Paid");
        if (payment.getId() == null || payment.getId().isEmpty()) {
            paymentService.add(payment);
        } else {
            paymentService.update(payment);
        }
        return "redirect:/bookings";
    }

    @GetMapping("/payments/{id}")
    public String paymentDetails(@PathVariable String id, HttpSession session, Model model) {
        requireAuthenticated(session);
        model.addAttribute("payment", paymentService.findById(id).orElse(new Payment()));
        return "payments/detail";
    }

    @GetMapping("/payments/{id}/edit")
    public String editPayment(@PathVariable String id, HttpSession session, Model model) {
        requireCustomer(session);
        model.addAttribute("payment", paymentService.findById(id).orElse(new Payment()));
        List<Booking> bookings = bookingService.findByCustomer((String) session.getAttribute("userId"));
        model.addAttribute("bookings", bookings);
        model.addAttribute("vendors", vendorService.findAll());
        model.addAttribute("bookingTotals", bookingTotals(bookings));
        return "payments/form";
    }

    @PostMapping("/payments/{id}/delete")
    public String deletePayment(@PathVariable String id, HttpSession session) {
        requireAuthenticated(session);
        paymentService.delete(id);
        return "redirect:/payments";
    }

    @GetMapping("/feedbacks")
    public String feedbacks(HttpSession session, Model model) {
        String role = (String) session.getAttribute("role");
        String customerId = (String) session.getAttribute("userId");
        if ("CUSTOMER".equals(role)) {
            model.addAttribute("feedbacks", feedbackService.findByCustomer(customerId));
        } else {
            model.addAttribute("feedbacks", feedbackService.findAll());
        }
        return "feedbacks/list";
    }

    @GetMapping("/feedbacks/new")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedbacks/form";
    }

    @PostMapping("/feedbacks")
    public String saveFeedback(@ModelAttribute Feedback feedback, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            feedback.setCustomerId((String) session.getAttribute("userId"));
        } else if (feedback.getCustomerId() == null) {
            feedback.setCustomerId("");
        }
        if (feedback.getId() == null || feedback.getId().isEmpty()) {
            feedbackService.add(feedback);
        } else {
            feedbackService.update(feedback);
        }
        return session.getAttribute("role") == null ? "redirect:/feedback" : "redirect:/feedbacks";
    }

    @GetMapping("/feedbacks/{id}")
    public String feedbackDetails(@PathVariable String id, Model model) {
        model.addAttribute("feedback", feedbackService.findById(id).orElse(new Feedback()));
        return "feedbacks/detail";
    }

    @GetMapping("/feedbacks/{id}/edit")
    public String editFeedback(@PathVariable String id, Model model) {
        model.addAttribute("feedback", feedbackService.findById(id).orElse(new Feedback()));
        return "feedbacks/form";
    }

    @PostMapping("/feedbacks/{id}/status")
    public String updateFeedbackStatus(@PathVariable String id, @RequestParam String status, HttpSession session) {
        requireAdmin(session);
        feedbackService.updateStatus(id, status);
        return "redirect:/feedbacks";
    }

    @PostMapping("/feedbacks/{id}/delete")
    public String deleteFeedback(@PathVariable String id, HttpSession session) {
        requireAuthenticated(session);
        feedbackService.delete(id);
        return "redirect:/feedbacks";
    }

    private void requireAuthenticated(HttpSession session) {
        if (session.getAttribute("role") == null) {
            throw new IllegalStateException("Login required");
        }
    }

    private void requireCustomer(HttpSession session) {
        if (!"CUSTOMER".equals(session.getAttribute("role"))) {
            throw new IllegalStateException("Customer login required");
        }
    }

    private void requireAdmin(HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("role"))) {
            throw new IllegalStateException("Admin login required");
        }
    }

    private Map<String, Double> bookingTotals(List<Booking> bookings) {
        return bookings.stream().collect(Collectors.toMap(Booking::getId, booking -> packageTotal(booking.getVendorId())));
    }

    private double packageTotal(String vendorIds) {
        if (vendorIds == null || vendorIds.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (String vendorId : vendorIds.split(",")) {
            total += vendorService.findById(vendorId.trim()).map(Vendor::getPackagePrice).orElse(0.0);
        }
        return total;
    }
}
