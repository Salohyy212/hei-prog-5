package state;

import engine.Game;

public interface GameState {
    void tick(Game game);
}
