package coordinate.model;

import java.util.List;

public class Rectangular extends AbstractFigure{

    private static final String PREFIX = "직사각형의 넓이는 ";

    public Rectangular(List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight(); // 넓이 * 높이
    }

    private int getWidth() {
        return getMaxPointValue(Point::getPointX) - getMinPointValue(Point::getPointX);
    }

    private int getHeight() {
        return getMaxPointValue(Point::getPointY) - getMinPointValue(Point::getPointY);
    }

    @Override
    public String getAreaInfo() {
        return PREFIX + getArea();
    }
}
