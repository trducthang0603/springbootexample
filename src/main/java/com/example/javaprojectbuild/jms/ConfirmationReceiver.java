package com.example.javaprojectbuild.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationReceiver {
    private Logger logger = LoggerFactory.getLogger(ConfirmationReceiver.class);
    @JmsListener(destination = "confirmationQueue",containerFactory = "connectionFactory")
    public void receiveConfirmation(Confirmation confirmation){
        logger.info(" >> Receive confirmation: "+confirmation);
    }
}
