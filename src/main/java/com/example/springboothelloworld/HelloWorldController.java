package com.example.springboothelloworld;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private final ApplicationContext context;




	public HelloWorldController(final ApplicationContext context) {

		this.context = context;
	}


	@GetMapping("/hello")
	String hello() {

		final String version = context.getBeansWithAnnotation(SpringBootApplication.class).entrySet().stream()
				.findFirst()
				.map(entry -> entry.getValue().getClass().getPackage().getImplementationVersion())
				.orElse("?");

		return "Hello World by this REST service version " + version;
	}
}
