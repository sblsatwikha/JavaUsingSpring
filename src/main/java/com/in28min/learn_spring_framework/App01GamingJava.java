package com.in28min.learn_spring_framework;

import com.in28min.learn_spring_framework.game.GameRunner;
import com.in28min.learn_spring_framework.game.MarioGame;
import com.in28min.learn_spring_framework.game.PacmanGame;
import com.in28min.learn_spring_framework.game.SuperContraGame;

public class App01GamingJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 marioGame = new MarioGame();
//		 superContraGame = new SuperContraGame();
		var pacmanGame = new PacmanGame();
		var gameRunner = new GameRunner(pacmanGame);
		gameRunner.run();
	}

}
