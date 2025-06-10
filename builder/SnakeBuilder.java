package builder;

import java.util.*;
import model.*;

public class SnakeBuilder {
    public Snake buildInitialSnake() {
        List<Point> initial = new ArrayList<>();
        initial.add(new Point(5, 5));
        initial.add(new Point(4, 5));
        initial.add(new Point(3, 5));
        return new Snake(initial);
    }
}
