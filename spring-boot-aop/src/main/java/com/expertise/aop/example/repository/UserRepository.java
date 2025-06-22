package com.expertise.aop.example.repository;

import com.expertise.aop.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
