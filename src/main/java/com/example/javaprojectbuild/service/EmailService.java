package com.example.javaprojectbuild.service;

import org.springframework.stereotype.Component;

@Component("emailservice")
public class EmailService implements MessageService{

	public void sendMsg(String message) {
		System.out.println(message);
	}

}
