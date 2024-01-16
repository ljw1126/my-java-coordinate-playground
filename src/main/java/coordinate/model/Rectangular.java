package coordinate.model;

import java.util.List;
import java.util.function.Function;

public class Rectangular {

    private static final String PREFIX = "직사각형의 넓이는 ";
    private static final int MAX_VALUE = 24;

    private List<Point> points;

    public Rectangular(List<Point> points) {
        this.points = points;
    }

    public boolean hasPoint(int x, int y) {
        Point other = new Point(x, y);
        return points.stream().anyMatch(point -> point.equals(other));
    }

    public double getArea() {
        return getWidth() * getHeight(); // 넓이 * 높이
    }

    private int getWidth() {
        return getMaxPointValue(Point::getPointX) - getMinPointValue(Point::getPointX);
    }

    private int getHeight() {
        return getMaxPointValue(Point::getPointY) - getMinPointValue(Point::getPointY);
    }

    private int getMinPointValue(Function<Point, Integer> pointIntegerFunction) {
        return points.stream().map(pointIntegerFunction).reduce(MAX_VALUE, Integer::min);
    }

    private int getMaxPointValue(Function<Point, Integer> pointIntegerFunction) {
        return points.stream().map(pointIntegerFunction).reduce(0, Integer::max);
    }
    
    public String getAreaInfo() {
        return PREFIX + getArea();
    }
}
