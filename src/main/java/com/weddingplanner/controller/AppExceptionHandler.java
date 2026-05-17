package com.weddingplanner.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(IllegalStateException.class)
    public String handleAccess(IllegalStateException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        if (ex.getMessage() != null && ex.getMessage().toLowerCase().contains("admin")) {
            return "auth/admin-login";
        }
        return "auth/user-login";
    }
}
