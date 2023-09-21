package com.example.javaprojectbuild.service;

import org.springframework.stereotype.Component;

@Component("smsservice")
public class SMSService implements MessageService{

	public void sendMsg(String message) {
		System.out.println(message);
	}

}
