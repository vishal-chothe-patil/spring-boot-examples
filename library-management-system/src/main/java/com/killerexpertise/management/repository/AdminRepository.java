package com.killerexpertise.management.repository;

import com.killerexpertise.management.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminRepository {

    private Map<Integer, Admin> adminMap = new HashMap<>();

    public void save(Admin admin) {
        adminMap.put(admin.getId(), admin);
    }

    public Admin findByUsernameAndPassword(String username, String password) {
        for (Admin admin : adminMap.values()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public List<Admin> findAll() {
        return new ArrayList<>(adminMap.values());
    }

    public Admin findByAdminName(String adminName) {
        for (Admin admin : adminMap.values()) {
            if (admin.getAdminName().equalsIgnoreCase(adminName)) {
                return admin;
            }
        }
        return null;
    }
}
