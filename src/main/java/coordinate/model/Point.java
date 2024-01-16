package coordinate.model;

import java.util.Objects;

public class Point {
    private PointX pointX;
    private PointY pointY;

    public Point(int x, int y) {
        this.pointX = new PointX(x);
        this.pointY = new PointY(y);
    }

    public int getPointX() {
        return pointX.getX();
    }

    public int getPointY() {
        return pointY.getY();
    }

    public double getDistance(Point other) {
        double operand1 = getPow(this.getPointX() - other.getPointX());
        double operand2 = getPow(this.getPointY() - other.getPointY());
        return Math.sqrt(operand1 + operand2);
    }

    private double getPow(int subtractionValue) {
        return Math.pow(subtractionValue, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(pointX, point.pointX) && Objects.equals(pointY, point.pointY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }
}
