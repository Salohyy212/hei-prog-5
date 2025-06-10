package strategy;

import model.Point;
import model.Snake;
import model.Direction;

public interface MoveStrategy {
    Point computeNextPosition(Snake snake, Direction direction);
}