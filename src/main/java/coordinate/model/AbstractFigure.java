package coordinate.model;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure{
    public static final int MAX_VALUE = 24;
    public static final String ERROR_FIGURE_NULL = "올바른 Point 값이 아닙니다";
    protected final List<Point> points;

    public AbstractFigure(List<Point> points) {
        if(points == null || points.isEmpty()) {
            throw new IllegalArgumentException(ERROR_FIGURE_NULL);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
