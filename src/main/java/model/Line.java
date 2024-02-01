package model;

import java.util.List;

public class Line extends AbstractFigure{
    public static final int POINT_SIZE = 2;
    private static final String INVALID_POINT_SIZE = String.format("선을 그리기 위한 점은 %s개가 필요합니다", POINT_SIZE);
    private static final String RESULT_PREFIX = "두 점 사이 거리는 ";

    public Line(List<Point> points) {
        super(points);
        if(points.size() != POINT_SIZE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE);
        }
    }

    public double getArea() {
        return this.points.get(0).calculateDistance(this.points.get(1));
    }

    @Override
    public String getAreaInfo() {
        return RESULT_PREFIX + getArea();
    }
}
