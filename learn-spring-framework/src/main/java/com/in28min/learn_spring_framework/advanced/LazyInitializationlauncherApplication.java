package com.in28min.learn_spring_framework.advanced;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class A{
	
}
//default is eager which is initialized at the application start
@Lazy
@Component
class B{
	A classA;
	public B(A classA) {
		System.out.println("Inialization");
		this.classA = classA;
	}
	
}

@Configuration
@ComponentScan
public class LazyInitializationlauncherApplication {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(LazyInitializationlauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(B.class));
		}
	}

}