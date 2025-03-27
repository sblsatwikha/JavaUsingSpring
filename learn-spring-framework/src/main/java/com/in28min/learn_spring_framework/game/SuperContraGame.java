package com.in28min.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGame")
public class SuperContraGame implements GameConsole{
	public void up() {
		System.out.println("Up");
	}
	
	public void down() {
		System.out.println("Sit Down");
	}
	
	public void right() {
		System.out.println("Shoot a bullet");
	}
	
	public void left() {
		System.out.println("Go back");
	}
}
