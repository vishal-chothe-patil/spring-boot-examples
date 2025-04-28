package com.killerexpertise.profile.concept.service.impl;

import com.killerexpertise.profile.concept.model.User;
import com.killerexpertise.profile.concept.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Profile("dev")
public class DevUserServiceImpl implements UserService {

    private final Map<String, User> userStore = new HashMap<>();

    @Override
    public void addUser(User user) {
        userStore.put(user.getUsername(), user);
        System.out.println("DEV MODE: User stored in memory - " + user.getUsername());
    }

    public Map<String, User> getAllUsers() {
        return userStore;
    }
}
