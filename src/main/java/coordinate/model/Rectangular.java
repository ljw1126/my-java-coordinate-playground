package coordinate.model;

import java.util.List;
import java.util.function.Function;

/**
 * Todo
 * 1. 직사각형 모양 검증
 * 2. 함수 분할하기
 */
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

    private int getMinPointValue(Function<Point, Integer> pointIntegerFunction) {
        return points.stream().map(pointIntegerFunction).reduce(MAX_VALUE, Integer::min);
    }

    private int getMaxPointValue(Function<Point, Integer> pointIntegerFunction) {
        return points.stream().map(pointIntegerFunction).reduce(0, Integer::max);
    }

    @Override
    public String getAreaInfo() {
        return PREFIX + getArea();
    }


}
