package coordinate.model;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    protected final List<Point> points;

    public AbstractFigure(List<Point> points) {
        this.points = points;
    }

    @Override
    public List<Point> getPoint() {
        return this.points;
    }

    @Override
    public boolean hasPoint(int x, int y) {
        return points.stream().anyMatch(point -> point.isSame(x, y));
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
