package coordinate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

// 결국 x, y 축 좌표가 각각 2개씩 존재해야 하고, 각 포인트의 차가 넓이, 높이가 된다
public class Rectangular {

    public static final int NUM_OF_RECTANGULAR = 4;
    private static final int TWO_POINT = 2;
    private static final String PREFIX_MESSAGE = "사각형 넓이는 ";

    private static final String INVALID_POINT_MESSAGE = "좌표 형식이 올바르지 않습니다";
    private final List<Point> points;

    public Rectangular(List<Point> points) {
        this.points = points;
        checkDistinctPointSize();
    }

    public double getArea() {
        int width = calculateDifference(getDistinctPoint(Point::getX));
        int heigth = calculateDifference(getDistinctPoint(Point::getY));

        return width * heigth;
    }

    private void checkDistinctPointSize() {
        Set<Integer> setX = getDistinctPoint(Point::getX);
        Set<Integer> setY = getDistinctPoint(Point::getY);
        if(setX.size() != TWO_POINT || setY.size() != TWO_POINT) {
            throw new IllegalArgumentException(INVALID_POINT_MESSAGE);
        }
    }

    private Set<Integer> getDistinctPoint(Function<Point, Integer> pointIntegerFunction) {
        return this.points.stream().map(pointIntegerFunction).collect(toSet());
    }

    private int calculateDifference(Set<Integer> pointSet) {
        List<Integer> points = new ArrayList<>(pointSet);
        return Math.abs(points.get(0) - points.get(1));
    }

    public boolean hasPoint(int x, int y) {
        return points.stream().anyMatch(point -> point.isSame(x, y));
    }

    public String getAreaInfo() {
        return PREFIX_MESSAGE + getArea();
    }
}
