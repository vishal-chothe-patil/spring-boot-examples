package com.killerexpertise.management.service;



import com.killerexpertise.management.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
