package coordinate;

import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    // 거리 계산
    public double getDistance() {
        double operand1 = Math.pow((points.get(0).getPointX() - points.get(1).getPointX()), 2);
        double operand2 = Math.pow((points.get(0).getPointY() - points.get(1).getPointY()), 2);
        return Math.sqrt(operand1 + operand2);
    }
}
