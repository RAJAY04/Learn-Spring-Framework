package com.Ajay.LearnSpringFramework;

import com.Ajay.LearnSpringFramework.game.GameRunner;
import com.Ajay.LearnSpringFramework.game.GamingConsole;
import com.Ajay.LearnSpringFramework.game.PackmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App03GammingSpringBeans {
    public static void main(String[] args) {

        try (
                var context = new AnnotationConfigApplicationContext(GammingConfiguration.class)
        ) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
