/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    public boolean sendOtp(String to,String username,int otp) throws AddressException, MessagingException
    {
        String user="informatics003@gmail.com";
        String pass="eurotrip";
    
        Properties p=new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port","587");
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        
        Authenticator auth=new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pass);
            }
            
};
         
        Session ss=Session.getInstance(p, auth);
        Message msg=new MimeMessage(ss);
        msg.setFrom(new InternetAddress(user));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject("TechQuera Email Confirmation");
       String message="Hey,"+username +"your otp for Email verification is :"+otp;
       msg.setText(message);
       Transport.send(msg);
       return true;
    }
    
}
