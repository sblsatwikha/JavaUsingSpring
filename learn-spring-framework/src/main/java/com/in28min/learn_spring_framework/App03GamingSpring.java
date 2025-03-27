package com.in28min.learn_spring_framework;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28min.learn_spring_framework.game.GameConsole;
import com.in28min.learn_spring_framework.game.GameRunner;
import com.in28min.learn_spring_framework.game.MarioGame;
import com.in28min.learn_spring_framework.game.PacmanGame;
import com.in28min.learn_spring_framework.game.SuperContraGame;

@Configuration
@ComponentScan("com.in28min.learn_spring_framework.game")
public class App03GamingSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try (var context = new AnnotationConfigApplicationContext(App03GamingSpring.class)) {
			context.getBean(GameRunner.class).run();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
