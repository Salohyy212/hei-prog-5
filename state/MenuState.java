package state;

import java.util.Scanner;
import engine.Game;

public class MenuState implements GameState {
    public void tick(Game game) {
        System.out.println("Bienvenue dans Snake! Appuyez sur Entrée pour commencer.");
        new Scanner(System.in).nextLine();
        game.setState(new RunningState());
    }
}