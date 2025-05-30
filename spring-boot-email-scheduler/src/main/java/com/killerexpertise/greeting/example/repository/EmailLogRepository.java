package com.killerexpertise.greeting.example.repository;

import com.killerexpertise.greeting.example.model.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {

}
