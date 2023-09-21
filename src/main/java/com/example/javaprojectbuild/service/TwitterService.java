package com.example.javaprojectbuild.service;

import com.example.javaprojectbuild.service.MessageService;
import org.springframework.stereotype.Component;

@Component("twitterservice")
public class TwitterService implements MessageService {

	public void sendMsg(String message) {
		System.out.println(message);
	}

}
