package model;

import java.util.List;

/**
 * 헤론의 공식 사용
 * S (면적) = 루트(s(s -a)(s-b)(s-c))
 * 이때 s = (a + b + c) / 2
 */
public class Triangle extends AbstractFigure {
    public static final int POINT_SIZE = 3;
    private static final String INVALID_POINT_SIZE = String.format("삼각형을 그리기 위한 점은 %s개가 필요합니다", POINT_SIZE);
    private static final String RESULT_PREFIX = "삼각형 넓이는 ";

    private static final String INVALID_TRIANGLE_SHAPE = "유효하지 않은 삼각형입니다";

    public Triangle(List<Point> points) {
        super(points);

        checkInvalidTriangle(points);
    }

    /**
     * 기울기 : 두 점을 연결하는 직선의 경사를 나타낸다
     * 두 점의 기울기가 무한대(x1 == x2)라면 x축과 이루는 각도는 90도
     * 기울기(y1 == y2) == 0 은 수평, 기울기(x1 == x2) == 무한대는 수직을 나타냄
     */
    private static void checkInvalidTriangle(List<Point> points) {
        if(points.size() != POINT_SIZE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE);
        }

        if(getSlope(points.get(0), points.get(1)) == getSlope(points.get(0), points.get(2))) {
            throw new IllegalStateException(INVALID_TRIANGLE_SHAPE);
        }
    }

    private static double getSlope(Point point, Point other) {
        return point.calculateSlope(other);
    }

    @Override
    public double getArea() {
        double a = distance(this.points.get(0), this.points.get(1));
        double b = distance(this.points.get(0), this.points.get(2));
        double c = distance(this.points.get(1), this.points.get(2));

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getAreaInfo() {
        return RESULT_PREFIX + getArea();
    }

    private double distance(Point pointA, Point pointB) {
        return pointA.calculateDistance(pointB);
    }
}
