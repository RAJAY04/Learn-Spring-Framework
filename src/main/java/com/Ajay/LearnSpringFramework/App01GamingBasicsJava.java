package com.Ajay.LearnSpringFramework;

import com.Ajay.LearnSpringFramework.game.GameRunner;
import com.Ajay.LearnSpringFramework.game.PackmanGame;

public class App01GamingBasicsJava {
    public static void main(String[] args) {
//        var game = new MarioGame()
//        var game = new SuperContraGame();
        var game = new PackmanGame();//creation of object
        var gameRunner = new GameRunner(game);//creating of object + wiring of dependencies
            //game is a dependency
        //the dependency is created and injected into game runner class
        gameRunner.run();
    }
}
