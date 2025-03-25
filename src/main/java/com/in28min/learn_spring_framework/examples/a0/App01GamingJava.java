package com.in28min.learn_spring_framework.examples.a0;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28min.learn_spring_framework.game.GameRunner;


@Configuration
@ComponentScan("com.in28min.learn_spring_framework.game")
public class App01GamingJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try (var context = new AnnotationConfigApplicationContext(App01GamingJava.class)) {
			context.getBean(GameRunner.class).run();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}