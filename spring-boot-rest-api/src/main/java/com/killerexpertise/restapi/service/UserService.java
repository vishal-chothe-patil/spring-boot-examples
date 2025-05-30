package com.killerexpertise.restapi.service;

import com.killerexpertise.restapi.model.User;

import java.util.List;

public interface UserService {

    String addUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    String updateUser(Integer id, User updatedUser);

    String partiallyUpdateUser(Integer id, User partialUser);

    String deleteUser(Integer id);
}
