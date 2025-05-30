package com.killerexpertise.restapi.service.impl;

import com.killerexpertise.restapi.model.User;
import com.killerexpertise.restapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public String addUser(User user) {
        users.add(user);
        return "User added successfully!";
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> userOpt = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        return userOpt.orElse(null);
    }

    @Override
    public String updateUser(Integer id, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, updatedUser);
                return "User updated successfully!";
            }
        }
        return "User not found!";
    }

    @Override
    public String partiallyUpdateUser(Integer id, User partialUser) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                if (partialUser.getName() != null) user.setName(partialUser.getName());
                if (partialUser.getEmail() != null) user.setEmail(partialUser.getEmail());
                if (partialUser.getMobile() != null) user.setMobile(partialUser.getMobile());
                return "User partially updated!";
            }
        }
        return "User not found!";
    }

    @Override
    public String deleteUser(Integer id) {
        boolean removed = users.removeIf(user -> user.getId().equals(id));
        return removed ? "User deleted successfully!" : "User not found!";
    }
}
