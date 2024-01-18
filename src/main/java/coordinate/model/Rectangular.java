package coordinate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

// 결국 x, y 축 좌표가 각각 2개씩 존재해야 하고, 각 포인트의 차가 넓이, 높이가 된다
public class Rectangular extends AbstractFigure {

    public static final int NUM_OF_RECTANGULAR = 4;
    private static final int TWO_POINT = 2;
    private static final String PREFIX_MESSAGE = "사각형 넓이는 ";

    private static final String INVALID_POINT_MESSAGE = "좌표 형식이 올바르지 않습니다";

    public Rectangular(List<Point> points) {
        super(points);
        checkDistinctPointSize(points);
    }

    @Override
    public double getArea() {
        int width = calculateDifference(getDistinctPoint(getPoint(), Point::getX));
        int height = calculateDifference(getDistinctPoint(getPoint(), Point::getY));

        return width * height;
    }

    private void checkDistinctPointSize(List<Point> points) {
        Set<Integer> setX = getDistinctPoint(points, Point::getX);
        Set<Integer> setY = getDistinctPoint(points, Point::getY);
        if(setX.size() != TWO_POINT || setY.size() != TWO_POINT) {
            throw new IllegalArgumentException(INVALID_POINT_MESSAGE);
        }
    }

    private Set<Integer> getDistinctPoint(List<Point> points, Function<Point, Integer> pointIntegerFunction) {
        return points.stream().map(pointIntegerFunction).collect(toSet());
    }

    private int calculateDifference(Set<Integer> pointSet) {
        List<Integer> points = new ArrayList<>(pointSet);
        return Math.abs(points.get(0) - points.get(1));
    }

    @Override
    public String getAreaInfo() {
        return PREFIX_MESSAGE + getArea();
    }
}
