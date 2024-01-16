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
