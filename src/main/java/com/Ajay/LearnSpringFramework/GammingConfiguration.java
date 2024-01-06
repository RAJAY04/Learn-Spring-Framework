package com.Ajay.LearnSpringFramework;
import com.Ajay.LearnSpringFramework.game.GameRunner;
import com.Ajay.LearnSpringFramework.game.GamingConsole;
import com.Ajay.LearnSpringFramework.game.PackmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GammingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PackmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}
