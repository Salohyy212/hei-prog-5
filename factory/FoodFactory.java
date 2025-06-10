package factory;

import java.util.*;
import model.*;

public class FoodFactory {
    private Random random = new Random();

    public Point generateFood(List<Point> snakeBody, int gridSize) {
        Point food;
        do {
            food = new Point(random.nextInt(gridSize), random.nextInt(gridSize));
        } while (snakeBody.contains(food));
        return food;
    }

}