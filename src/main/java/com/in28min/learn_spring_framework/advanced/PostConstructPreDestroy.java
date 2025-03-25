package com.in28min.learn_spring_framework.advanced;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//Default is Singleton
@Component
class SomeClass{
	SomeDepoendency dep;
	public SomeClass(SomeDepoendency dep) {
		this.dep = dep;
		System.out.println("Dependemcies are ready");
	}
	
	public void someMethod() {
		System.out.println("NOTHINGGGGGGGGGs");
	}
	
	@PostConstruct
	public void initializ() {
		System.out.println("Start - initializ - @PostConstruct");
		dep.inDependency();
		System.out.println("Finish - initializ - @PostConstruct");
		
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("cleanup - @@PreDestroy");
	}
}

@Component
class SomeDepoendency{
	public void inDependency() {
		System.out.println("inDependency");
	}
}

@Configuration
@ComponentScan
public class PostConstructPreDestroy {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(PostConstructPreDestroy.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);			
		}
	}

}