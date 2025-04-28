package com.killerexpertise.management.repository;

import com.killerexpertise.management.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<Integer, User> userStore = new HashMap<>();

    public void save(User user) {
        userStore.put(user.getUid(), user);
    }

    public List<User> findAll() {
        return new ArrayList<>(userStore.values());
    }

    public User findById(int id) {
        return userStore.get(id);
    }

    public void deleteById(int id) {
        userStore.remove(id);
    }
}
