package com.example.javaprojectbuild.jms;
import javax.jms.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserReceiver {
    private Logger logger = LoggerFactory.getLogger(UserReceiver.class);
    private static AtomicInteger id = new AtomicInteger();

    @Autowired
    ConfirmationSender confirmationSender;

    @JmsListener(destination = "userQueue", containerFactory = "connectionFactory")
    public void receiveMessage(User receivedUser, Message message) {
        logger.info(" >> Original received message: " + message);
        logger.info(" >> Received user: " + receivedUser);
        confirmationSender.sendMessage(new Confirmation(id.incrementAndGet(), "User "
                + receivedUser.getEmail() + " received."));

    }
}
