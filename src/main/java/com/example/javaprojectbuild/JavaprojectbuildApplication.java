package com.example.javaprojectbuild;

import com.example.javaprojectbuild.service.MessageProcessorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@SpringBootApplication
public class JavaprojectbuildApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaprojectbuildApplication.class);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	public static void main(String[] args) {
		//ApplicationContext applicationContext = SpringApplication.run(JavaprojectbuildApplication.class, args);
		//applicationContext.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/springboot2webapp"));
//		MessageProcessorImpl userService = applicationContext.getBean(MessageProcessorImpl.class);
//		userService.processMsg("twitter message sending ");

			SpringApplication.run(JavaprojectbuildApplication.class, args);

		//SpringApplication app = new SpringApplication(JavaprojectbuildApplication.class);
		//app.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/springboot2webapp"));
		//app.run(args);
	}
}
