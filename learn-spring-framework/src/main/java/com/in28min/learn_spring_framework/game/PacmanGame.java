package com.in28min.learn_spring_framework.game;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("PacmanGame")
public class PacmanGame implements GameConsole {

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Up");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Up");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Up");
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Up");
	}

}
