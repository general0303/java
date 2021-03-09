package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;


    @Async
    public void sendEmailDoctor(Doctor w) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("psh030302@yandex.ru");
        message.setSubject("DoctorCreation");
        message.setText("Doctor created " + w.toString());
        javaMailSender.send(message);
    }

    @Async
    public void sendEmailPatient(Patient w) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("psh030302@yandex.ru");
        message.setSubject("PatientCreation");
        message.setText("Patient created " + w.toString());
        javaMailSender.send(message);
    }
}
