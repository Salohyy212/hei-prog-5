package strategy;

import model.*;

public class DefaultMoveStrategy implements MoveStrategy {
    public Point computeNextPosition(Snake snake, Direction direction) {
        Point head = snake.getHead();
        switch (direction) {
            case UP: return new Point(head.x, head.y - 1);
            case DOWN: return new Point(head.x, head.y + 1);
            case LEFT: return new Point(head.x - 1, head.y);
            case RIGHT: return new Point(head.x + 1, head.y);
        }
        return head; // fallback
    }
}
