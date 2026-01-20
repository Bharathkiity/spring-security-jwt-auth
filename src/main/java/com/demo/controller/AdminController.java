package com.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")//method-level security authorization
    public String adminDashboard() {
        return "ADMIN DASHBOARD - ADMIN ONLY";
    }
}
