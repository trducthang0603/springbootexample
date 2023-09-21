package com.example.javaprojectbuild.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessorImpl implements MessageProcessor {
	@Autowired
	@Qualifier("twitterservice")
	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void processMsg(String message) {
		//System.out.println("abc");
		messageService.sendMsg(message);
	}
}
