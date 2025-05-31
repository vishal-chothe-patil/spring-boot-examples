package com.killerexpertise.greeting.example.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.killerexpertise.greeting.example.model.Customer;
import com.killerexpertise.greeting.example.model.EmailLog;
import com.killerexpertise.greeting.example.repository.CustomerRepository;
import com.killerexpertise.greeting.example.repository.EmailLogRepository;
import com.killerexpertise.greeting.example.service.EmailServiceI;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailServiceI {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailLogRepository emailLogRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void sendGoodMorningEmails() {
        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            try {
                sendEmail(customer.getEmail(), customer.getName());
            } catch (Exception e) {
                logEmailActivity(customer.getEmail(), "FAILED");
                logger.error("Failed to send Good Morning email to: {}", customer.getEmail(), e);
            }
        }
    }

    private void sendEmail(String to, String name) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Good Morning, " + name + " ☀️");

        String emailContent =
                "<html><body style='font-family:Arial, sans-serif;'>" +
                        "<div style='max-width:600px; margin:auto; padding:20px;'>" +

                        "<h2>Good Morning, " + name + "!</h2>" +
                        "<p>Hope you're waking up refreshed and ready to seize the day!</p>" +
                        "<p>Here’s a little motivation for you:</p>" +
                        "<blockquote style='margin:10px 0; font-style:italic;'>" +
                        "“Every morning we are born again. What we do today is what matters most.”" +
                        "</blockquote>" +

                        "<div style='text-align:center; margin:20px 0;'>" +
                        "<img src='https://thumbs.dreamstime.com/b/beautiful-girl-bed-good-morning-young-wake-up-morning-home-64923142.jpg?w=576'" +
                        " alt='Good Morning' style='width:60%; max-width:300px; height:auto; border-radius:10px;'/>" +
                        "</div>" +

                        "<p style='margin-top:20px;'>Best regards,<br/>Your Friendly Team<br/>" +
                        "<strong>KillerExpertise</strong></p>" +

                        "</div>" +
                        "</body></html>";

        helper.setText(emailContent, true);

        mailSender.send(message);
        logEmailActivity(to, "SENT");
        logger.info("Good Morning email sent to: {}", to);
    }

    private void logEmailActivity(String recipientEmail, String status) {
        EmailLog log = new EmailLog();
        log.setRecipientEmail(recipientEmail);
        log.setStatus(status);
        log.setTimestamp(LocalDateTime.now());
        emailLogRepository.save(log);
        logger.info("Email log: {} to {}", status, recipientEmail);
    }
}
