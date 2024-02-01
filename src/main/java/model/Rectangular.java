package model;

import java.util.List;

public class Rectangular {
    private static final int POINT_SIZE = 4;
    private static final String INVALID_POINT_SIZE = String.format("사각형을 그리기 위한 점은 %s개가 필요합니다", POINT_SIZE);
    private static final String RESULT_PREFIX = "사각형 넓이는 ";
    private final Points points;

    public Rectangular(List<Point> points) {
        if(points.size() != POINT_SIZE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE);
        }
        this.points = new Points(points);
    }

    public double calculateArea() {
        List<Integer> pointX = points.getDistinctPoint(Point::getX);
        List<Integer> pointY = points.getDistinctPoint(Point::getY);

        return abs(pointX.get(0) - pointX.get(1)) * abs(pointY.get(0) - pointY.get(1));
    }

    private int abs(int value) {
        return Math.abs(value);
    }

    public String result() {
        return RESULT_PREFIX + calculateArea();
    }
}
