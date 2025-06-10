package state;

import engine.Game;

public class GameOverState implements GameState {
    public void tick(Game game) {
        System.out.println("Game Over ! Score : " + game.getScore());
        System.exit(0);
    }
}