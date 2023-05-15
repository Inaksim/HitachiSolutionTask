package com.example.Task.FXApplication.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

public class EmailSenderService {
    public void sendEmailWithAttachment(String senderEmail, String senderPassword,
                                        String receiverEmail, File filePath) throws MessagingException {

        JavaMailSender mailSender = new JavaMailSenderImpl();


        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderEmail);
            helper.setTo(receiverEmail);
            helper.setSubject("Weather Report");
            helper.setText("Text");
            helper.addAttachment("WeatherReport",filePath);
        } catch (MessagingException e) {

            e.printStackTrace();
        }

        JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) mailSender;
        mailSenderImpl.setUsername(senderEmail);
        mailSenderImpl.setPassword(senderPassword);
        mailSenderImpl.setHost("smtp.gmail.com");
        mailSenderImpl.setPort(465);
        mailSenderImpl.setProtocol("smtps");



        mailSender.send(message);
    }
}
