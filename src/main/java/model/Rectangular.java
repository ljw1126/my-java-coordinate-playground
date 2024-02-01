package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Rectangular extends AbstractFigure {
    public static final int POINT_SIZE = 4;
    private static final String INVALID_POINT_SIZE = String.format("사각형을 그리기 위한 점은 %s개가 필요합니다", POINT_SIZE);
    private static final String RESULT_PREFIX = "사각형 넓이는 ";
    private static final String INVALID_FORMAT = "직사각형이 아닙니다";
    private static final int TWO_POINT = 2;

    public Rectangular(List<Point> points) {
        super(points);
        checkInvalidPoint(points);
    }

    private void checkInvalidPoint(List<Point> points) {
        if(points.size() != POINT_SIZE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE);
        }

        Set<Integer> setX = new HashSet<>(distinctPoint(points, Point::getX));
        Set<Integer> setY = new HashSet<>(distinctPoint(points, Point::getY));
        if(setX.size() != TWO_POINT || setY.size() != TWO_POINT) {
            throw new IllegalArgumentException(INVALID_FORMAT);
        }
    }

    @Override
    public String getAreaInfo() {
        return RESULT_PREFIX + getArea();
    }

    @Override
    public double getArea() {
        double width = calculateDifference(distinctPoint(this.points, Point::getX));
        double height = calculateDifference(distinctPoint(this.points, Point::getY));

        return width * height;
    }

    private double calculateDifference(List<Integer> points) {
        return Math.abs(points.get(0) - points.get(1));
    }

    private List<Integer> distinctPoint(List<Point> pointList, Function<Point, Integer> mapFunction) {
        return pointList.stream()
                .map(mapFunction)
                .distinct()
                .collect(toList());
    }
}
