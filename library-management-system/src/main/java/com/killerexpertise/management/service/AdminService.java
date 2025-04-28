package com.killerexpertise.management.service;

import com.killerexpertise.management.model.Admin;

import java.util.List;

public interface AdminService {
    void registerAdmin(Admin admin);
    Admin login(String username, String password);
    List<Admin> getAllAdmins();
    Admin getAdminByName(String name);
}
