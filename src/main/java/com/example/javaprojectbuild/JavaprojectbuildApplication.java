package com.example.javaprojectbuild;

import javax.jms.ConnectionFactory;
import com.example.javaprojectbuild.jms.User;
import com.example.javaprojectbuild.model.Employee;
import com.example.javaprojectbuild.model.Instructor;
import com.example.javaprojectbuild.model.InstructorDetail;
import com.example.javaprojectbuild.repository.EmployeeRepository;
import com.example.javaprojectbuild.repository.InstructorRepository;
import com.example.javaprojectbuild.service.MessageProcessorImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
public class JavaprojectbuildApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(JavaprojectbuildApplication.class);
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaprojectbuildApplication.class);
	}
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	public static void main(String[] args) throws IOException {
		//ApplicationContext applicationContext = SpringApplication.run(JavaprojectbuildApplication.class, args);
		//applicationContext.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/springboot2webapp"));
//		MessageProcessorImpl userService = applicationContext.getBean(MessageProcessorImpl.class);
//		userService.processMsg("twitter message sending ");

		ConfigurableApplicationContext context =
		 SpringApplication.run(JavaprojectbuildApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending an user message.");
		jmsTemplate.convertAndSend("userQueue",
				new User("rameshfadatare@gmail.com", 5d, true));
		jmsTemplate.convertAndSend("userQueue",
				new User("rameshfadatare11111111111@gmail.com", 5d, true));
		logger.info("Waiting for user and confirmation ...");
		System.in.read();
		context.close();
		// config duong dan
		//SpringApplication app = new SpringApplication(JavaprojectbuildApplication.class);
		//app.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/springboot2webapp"));
		//app.run(args);


	}
	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean
	public JmsListenerContainerFactory<?> connectionFactory(ConnectionFactory connectionFactory,
															DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message converter
		configurer.configure(factory, connectionFactory);
		// You could still override some of Boot's default if necessary.
		return factory;
	}
	@Override
	public void run(String... args) throws Exception {

		employeeRepository.save(new Employee("Ramesh", "Fadatare", "ramesh@gmail.com"));
		employeeRepository.save(new Employee("Tom", "Cruise", "tom@gmail.com"));
		employeeRepository.save(new Employee("John", "Cena", "john@gmail.com"));
		employeeRepository.save(new Employee("tony", "stark", "stark@gmail.com"));
		// get list of employees
		List<Employee> employees = employeeRepository.findAll();
		employees.forEach(employee -> System.out.println(employee.toString()));
		Instructor instructor = new Instructor("Ramesh", "Fadatare", "ramesh@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("Java Guides", "Cricket Playing");
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);
		instructorRepository.save(instructor);
	}
}
