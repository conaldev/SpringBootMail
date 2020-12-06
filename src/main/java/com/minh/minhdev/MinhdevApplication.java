package com.minh.minhdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
public class MinhdevApplication {

    @Autowired
    SendMailService sendMailService;
    public static void main(String[] args) {
        SpringApplication.run(MinhdevApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerWhenStart() {
        String subject = "Test mail from Project Management System";
        String content = "<h1>Be happy, Enjoy Life...!!!</h1>";
        sendMailService.sendEmail("ilikeshinomiyakaguya@gmail.com",content,subject ,true, true);

    }

}
