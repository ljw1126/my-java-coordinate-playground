package model;

import java.util.List;

public abstract class AbstractFigure implements Figure {

    protected final List<Point> points;

    public AbstractFigure(List<Point> points) {
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return this.points;
    }

    @Override
    public boolean hasPoint(int x, int y) {
        return this.points.stream()
                .anyMatch(point -> point.isSame(x, y));
    }
}
