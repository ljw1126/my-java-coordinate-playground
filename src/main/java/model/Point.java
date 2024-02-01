package model;

import java.util.Objects;

public class Point {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 24;

    private static final String INVALID_POINT = String.format("포인트 값은 %s ~ %s 사이의 값이여야 합니다", MIN_VALUE, MAX_VALUE);
    private int x;
    private int y;

    public Point(int x, int y) {
        if(invalidRange(x) || invalidRange(y)) {
            throw new IllegalArgumentException(INVALID_POINT);
        }
        this.x = x;
        this.y = y;
    }

    private boolean invalidRange(int point) {
        return point < MIN_VALUE || MAX_VALUE < point;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSame(int x, int y) {
        return this.x == x && this.y == y;
    }

    public double calculateDistance(Point other) {
        return Math.sqrt(pow(this.x - other.x) + pow(this.y - other.y));
    }

    public double pow(double value) {
        return Math.pow(value, 2);
    }

    //두 점의 기울기는 x축과 이루는 각도를 나타낸다(tan)
    public double calculateSlope(Point other) {
        if(this.x == other.x) { // *ArithmeticException / by zero 방지 부분
            return Double.MAX_VALUE;
        }

        return Math.abs((other.y - this.y) / (other.x - this.x));
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
}
