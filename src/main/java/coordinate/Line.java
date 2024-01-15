package coordinate;

import java.util.List;

public class Line {
    private static final String PREFIX = "두 점 사이의 거리는 ";
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean hasPoint(int x, int y) {
        Point point = new Point(x, y);
        return points.stream().anyMatch(point1 -> point1.equals(point));
    }

    // 거리 계산
    public double getDistance() {
        double operand1 = Math.pow((points.get(0).getPointX() - points.get(1).getPointX()), 2);
        double operand2 = Math.pow((points.get(0).getPointY() - points.get(1).getPointY()), 2);
        return Math.sqrt(operand1 + operand2);
    }

    public String toString() {
        return PREFIX + getDistance();
    }
}
