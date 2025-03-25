package com.in28min.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	GameConsole game;
	public GameRunner(@Qualifier("pacmanGame") GameConsole game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}
	public void run() {
		System.out.println("RUNRUN " + game);
		game.down();
		game.up();
		game.left();
		game.right();
	}

}
