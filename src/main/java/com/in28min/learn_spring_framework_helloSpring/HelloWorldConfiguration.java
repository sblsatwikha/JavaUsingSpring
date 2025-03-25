package com.in28min.learn_spring_framework_helloSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {}
record Address(String street, String city) {}

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Sath";
	}
	
	@Bean
	public int age() {
		return 25;
	}
	
	@Bean
	public Person person() {
		return new Person("Div", 25);
	}
	
	@Bean
	public Address address() {
		return new Address("23 St", "Washington");
	}
}
