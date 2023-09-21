package com.example.javaprojectbuild;

import com.example.javaprojectbuild.service.MessageProcessorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class JavaprojectbuildApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(JavaprojectbuildApplication.class, args);

//		MessageProcessorImpl userService = applicationContext.getBean(MessageProcessorImpl.class);
//		userService.processMsg("twitter message sending ");
	}

}
