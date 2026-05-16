package com.weddingplanner.controller;

import com.weddingplanner.model.Admin;
import com.weddingplanner.model.Customer;
import com.weddingplanner.service.FeedbackService;
import com.weddingplanner.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    private final UserService userService;
    private final FeedbackService feedbackService;

    public AuthController(UserService userService, FeedbackService feedbackService) {
        this.userService = userService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/feedback")
    public String feedback(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAll());
        return "feedback";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Customer customer, HttpSession session) {
        Customer saved = userService.registerCustomer(customer);
        session.setAttribute("userId", saved.getId());
        session.setAttribute("userName", saved.getName());
        session.setAttribute("role", "CUSTOMER");
        return "redirect:/user/dashboard";
    }

    @GetMapping("/user/login")
    public String userLogin() {
        return "auth/user-login";
    }

    @PostMapping("/user/login")
    public String userLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        return userService.authenticateCustomer(email, password).map(customer -> {
            session.setAttribute("userId", customer.getId());
            session.setAttribute("userName", customer.getName());
            session.setAttribute("role", "CUSTOMER");
            return "redirect:/user/dashboard";
        }).orElseGet(() -> {
            model.addAttribute("error", "Invalid customer email or password.");
            return "auth/user-login";
        });
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "auth/admin-login";
    }

    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        return userService.authenticateAdmin(email, password).map(admin -> {
            session.setAttribute("adminId", admin.getId());
            session.setAttribute("userName", admin.getName());
            session.setAttribute("role", "ADMIN");
            return "redirect:/admin/dashboard";
        }).orElseGet(() -> {
            model.addAttribute("error", "Invalid admin email or password.");
            return "auth/admin-login";
        });
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
