package coordinate.model;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractFigure implements Figure{
    public static final int MAX_VALUE = 24;
    protected final List<Point> points;

    public AbstractFigure(List<Point> points) {
        this.points = points;
    }

    @Override
    public boolean hasPoint(int x, int y) {
        Point other = new Point(x, y);
        return points.stream().anyMatch(point -> point.equals(other));
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    public int getMinPointValue(Function<Point, Integer> pointIntegerFunction) {
        return points.stream().map(pointIntegerFunction).reduce(MAX_VALUE, Integer::min);
    }

    public int getMaxPointValue(Function<Point, Integer> pointIntegerFunction) {
        return points.stream().map(pointIntegerFunction).reduce(0, Integer::max);
    }
}
