package model;

import java.util.*;

public class Snake {
    private LinkedList<Point> body = new LinkedList<>();
    private boolean grow = false;

    public Snake(List<Point> initialBody) {
        body.addAll(initialBody);
    }

    public Point getHead() {
        return body.getFirst();
    }

    public List<Point> getBody() {
        return body;
    }

    public void grow() {
        grow = true;
    }

    public void move(Point nextPosition) {
        body.addFirst(nextPosition);
        if (!grow) {
            body.removeLast();
        }
        grow = false;
    }

    public boolean collidesWith(Point p) {
        return body.contains(p);
    }
}