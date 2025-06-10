package state;

import java.util.*;
import model.*;
import engine.Game;
import strategy.*;

public class RunningState implements GameState {
    private Scanner scanner = new Scanner(System.in);

    public void tick(Game game) {
        Direction dir = game.getDirection();
        System.out.print("Direction (WASD) : ");
        String input = scanner.nextLine().toUpperCase();
        if (input.equals("W")) dir = Direction.UP;
        else if (input.equals("S")) dir = Direction.DOWN;
        else if (input.equals("A")) dir = Direction.LEFT;
        else if (input.equals("D")) dir = Direction.RIGHT;

        Point next = game.getMoveStrategy().computeNextPosition(game.getSnake(), dir);

        if (next.x < 0 || next.y < 0 || next.x >= game.getGridSize() || next.y >= game.getGridSize()
                || game.getSnake().collidesWith(next)) {
            game.setState(new GameOverState());
            return;
        }

        if (next.equals(game.getFood())) {
            game.getSnake().grow();
            game.incrementScore();
            game.setFood(game.getFoodFactory().generateFood(game.getSnake().getBody(), game.getGridSize()));
        }

        game.getSnake().move(next);
        game.setDirection(dir);
        drawGrid(game);
    }

    private void drawGrid(Game game) {
        int size = game.getGridSize();
        Point food = game.getFood();
        Set<Point> snakePoints = new HashSet<>(game.getSnake().getBody());
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Point p = new Point(x, y);
                if (game.getSnake().getHead().equals(p)) {
                    System.out.print("H ");
                } else if (snakePoints.contains(p)) {
                    System.out.print("* ");
                } else if (p.equals(food)) {
                    System.out.print("@ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Score : " + game.getScore());
    }
}

