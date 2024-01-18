package coordinate.model;

import java.util.List;

public class Line {
    private static final String INVALID_ARGUMENT_ERROR = "선을 만드는 점은 두 개여야 합니다";
    private static final String PREFIX_MESSAGE = "두 점 사이의 거리는 ";
    private static final int NUM_OF_LINE = 2;
    private final List<Point> points;

    public Line(List<Point> points) {
        checkSize(points);
        this.points = points;
    }

    private static void checkSize(List<Point> points) {
        if(points.size() != NUM_OF_LINE) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_ERROR);
        }
    }

    public double getDistance() {
        return points.get(0).calculateDistance(points.get(1));
    }

    public String getResult() {
        return PREFIX_MESSAGE + getDistance();
    }
}
