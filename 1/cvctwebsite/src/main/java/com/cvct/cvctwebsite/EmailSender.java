package com.cvct.cvctwebsite;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    private final JavaMailSender mailSender;

    public EmailSender(JavaMailSender mailSender)
    {
        this.mailSender = mailSender;
    }

    @Async

    public static void sendEmail(String to, String email, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setFrom(email);
        message.setSubject(subject);
        message.setText(body);
    }
    
}
