package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String INVALID_ARGUMENT_ERROR = "선을 만드는 점은 두 개여야 합니다";
    private static final String PREFIX_MESSAGE = "두 점 사이의 거리는 ";
    public static final int NUM_OF_LINE = 2;

    public Line(List<Point> points) {
        super(points);
        checkSize(points);
    }

    private static void checkSize(List<Point> points) {
        if(points.size() != NUM_OF_LINE) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_ERROR);
        }
    }

    @Override
    public double getArea() {
        List<Point> points = getPoint();
        return points.get(0).calculateDistance(points.get(1));
    }

    @Override
    public String getAreaInfo() {
        return PREFIX_MESSAGE + getArea();
    }
}
