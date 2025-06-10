package engine;

import model.*;
import strategy.*;
import factory.*;
import builder.*;
import state.*;

public class Game {
    private final int gridSize = 10;
    private GameState state;
    private Snake snake;
    private Point food;
    private Direction direction = Direction.RIGHT;
    private FoodFactory foodFactory = new FoodFactory();
    private MoveStrategy moveStrategy = new DefaultMoveStrategy();
    private int score = 0;

    public void run() {
        this.snake = new SnakeBuilder().buildInitialSnake();
        this.food = foodFactory.generateFood(snake.getBody(), gridSize);
        this.state = new MenuState();
        while (true) {
            state.tick(this);
        }
    }

    public int getGridSize() { return gridSize; }
    public Snake getSnake() { return snake; }
    public Point getFood() { return food; }
    public void setFood(Point food) { this.food = food; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction d) { direction = d; }
    public void setState(GameState s) { state = s; }
    public MoveStrategy getMoveStrategy() { return moveStrategy; }
    public FoodFactory getFoodFactory() { return foodFactory; }
    public int getScore() { return score; }
    public void incrementScore() { score++; }
}


