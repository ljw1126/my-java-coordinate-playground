package coordinate.model;

import java.util.Objects;

public class Point {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 24;
    private static final String INVALID_VALUE_MESSAGE = "좌표 값의 범위는 각각" + MIN_VALUE + "~" + MAX_VALUE + "사이 값만 가능합니다";

    private int x;
    private int y;

    private Point(int x, int y) {
        checkPointValue(x, y);
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    private void checkPointValue(int x, int y) {
        if(isInvalidValue(x) || isInvalidValue(y)) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
    }

    private boolean isInvalidValue(int value) {
        return value < MIN_VALUE || MAX_VALUE < value;
    }

    public double calculateDistance(Point point) {
        return Math.sqrt(squareDifference(x, point.x) + squareDifference(y, point.y));
    }

    private double squareDifference(int v1, int v2) {
        return Math.pow(v2 - v1, 2);
    }

    public boolean isSame(int x, int y) {
        return this.x == x && this.y == y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double calculateSlope(Point point) {
        if(this.x == point.x) {
            return Double.MAX_VALUE;
        }

        return Math.abs((point.y - this.y) / (point.x - this.x));
    }
}
