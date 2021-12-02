package com.pizza.agents.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Model(adaptables = Resource.class)
public class Email {

    private static final Logger log = LoggerFactory.getLogger(Email.class);

    public static Boolean sendEmail(String gestor, String client, String subject, String body){


        //Setting the properties

        Properties props = new Properties();

        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "pizzabay.005@gmail.com");
        props.setProperty("mail.smtp.clave", "005.pizzabay");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);

        session.setDebug(true);

        //Building the message

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("pizzabay.005@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(gestor));
            message.setSubject("Subject: "+ subject + "  ----->   Client`s contact email:  " + client);
            message.setText(body);


        //Sending the message

            Transport t = session.getTransport("smtp");

            t.connect("pizzabay.005@gmail.com", "005.pizzabay");
            t.sendMessage(message, message.getAllRecipients());
            t.close();

            return true;

        } catch (Exception e) {
            log.info("Exception {}", e.getMessage());

            return false;
        }

    }
}
