package com.killerexpertise.management.service.impl;

import com.killerexpertise.management.model.Admin;
import com.killerexpertise.management.repository.AdminRepository;
import com.killerexpertise.management.service.AdminService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void registerAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public Admin login(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminByName(String name) {
        return adminRepository.findByAdminName(name);
    }
}
