/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
  
    @Autowired
    public JavaMailSender emailSender;
//    public JavaMailSender emailSender = new JavaMailSenderImpl();
 
    public void sendSimpleMessage(
       
      String from, String to, String subject, String text) {
//        ...
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setFrom(from); 
        message.setSubject(subject); 
        message.setText(text);
        System.out.println("message text:" + message);
        System.out.println("emailsender:" + emailSender + "\n");
        try{
        emailSender.send(message);
        }
        catch (Exception e)
        {
            System.out.println("\nemail fail exception: \n" + e);
        }
//        ...
    }
}
