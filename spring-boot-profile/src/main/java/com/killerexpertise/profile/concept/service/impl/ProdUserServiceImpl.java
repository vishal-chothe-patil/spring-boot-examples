package com.killerexpertise.profile.concept.service.impl;

import com.killerexpertise.profile.concept.model.User;
import com.killerexpertise.profile.concept.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Profile("prod")
public class ProdUserServiceImpl implements UserService {

    private final Map<String, User> userStore = new HashMap<>();

    @Override
    public void addUser(User user) {
        // Save user into the HashMap
        userStore.put(user.getUsername(), user);
        System.out.println("PROD MODE: User saved to 'database' - " + user.getUsername() + ", " + user.getEmail());
    }

    public Map<String, User> getAllUsers() {
        return userStore;
    }
}
