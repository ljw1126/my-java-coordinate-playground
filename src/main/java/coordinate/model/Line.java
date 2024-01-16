package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String PREFIX = "두 점 사이의 거리는 ";

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
       return points.get(0).getDistance(points.get(1));
    }

    @Override
    public String getAreaInfo() {
        return PREFIX + getArea();
    }
}
