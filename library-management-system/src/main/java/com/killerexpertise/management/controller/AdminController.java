package com.killerexpertise.management.controller;

import com.killerexpertise.management.model.Admin;
import com.killerexpertise.management.service.AdminService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@Setter
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public String registerAdmin(@RequestBody Admin admin) {
        logger.info("Registering new admin: {}", admin.getUsername());
        adminService.registerAdmin(admin);
        return "Admin registered successfully!";
    }

    @PostMapping("/authenticate")
    public Admin authenticateAdmin(
            @RequestParam String username,
            @RequestParam String password) {
        logger.info("Authenticating admin: {}", username);
        return adminService.login(username, password);
    }

    @GetMapping("/get-all")
    public List<Admin> getAllAdmins() {
        logger.info("Fetching all admins");
        return adminService.getAllAdmins();
    }

    @GetMapping("/search/by-name/{adminName}")
    public Admin getAdminByName(@PathVariable String adminName) {
        logger.info("Searching admin by name: {}", adminName);
        return adminService.getAdminByName(adminName);
    }
}
