package coordinate.model;

import java.util.List;

/**
 * 헤론의 공식
 * s = (a + b + c) / 2   -- 이때 a, b, c는 선의 길이
 * S (면적) = Math.sqrt( s(s - a)(s - b)(s - c) )
 */
public class Triangle extends AbstractFigure {
    private static final String PREFIX = "삼각형 넓이는 ";

    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        List<Point> pointList = getPoints();
        double a = pointList.get(0).getDistance(pointList.get(1));
        double b = pointList.get(0).getDistance(pointList.get(2));
        double c = pointList.get(1).getDistance(pointList.get(2));
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getAreaInfo() {
        return PREFIX + getArea();
    }
}
