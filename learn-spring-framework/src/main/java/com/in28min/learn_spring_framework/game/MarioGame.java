package com.in28min.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GameConsole {
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Go into the hole");
	}
	
	public void right() {
		System.out.println("Accelerate");
	}
	
	public void left() {
		System.out.println("Go back");
	}
}
