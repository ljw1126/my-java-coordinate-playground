package coordinate.model;

import java.util.HashSet;
import java.util.List;

// 헤론의 법칙
// s = (a + b + c) / 2  -- 이때 a, b, c는 각 빗변 길이
// S(면적) = Math.sqrt(s * (s - a) * (s - b) * (s - c))
public class Triangle extends AbstractFigure {

    public static final int NUM_OF_TRIANGLE = 3;
    private static final String PREFIX_MESSAGE = "삼각형 넓이는 ";

    private static final String INVALID_POINT_SIZE = "삼각형 모양이 아닙니다";
    public Triangle(List<Point> points) {
        super(points);
        if(isInStraightLine(points)) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE);
        }
    }

    // 한점을 기준으로 나머지 두 점과 같은 각도를 이룰 경우 삼각형이 아니다
    private boolean isInStraightLine(List<Point> points) {
        return points.get(0).calculateSlope(points.get(1)) == points.get(0).calculateSlope(points.get(2));
    }

    @Override
    public double getArea() {
        double a = getDistanceBetween(points.get(0), points.get(1));
        double b = getDistanceBetween(points.get(0), points.get(2));
        double c = getDistanceBetween(points.get(1), points.get(2));
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private double getDistanceBetween(Point a, Point b) {
        return a.calculateDistance(b);
    }

    private double getSlope(Point a, Point b) {
        return a.calculateSlope(b);
    }

    @Override
    public String getAreaInfo() {
        return PREFIX_MESSAGE + getArea();
    }
}
