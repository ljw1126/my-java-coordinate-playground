package model;

import java.util.List;

public class Points {
    private List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public double getDifferenceX() {
        return points.get(0).getX() - points.get(1).getX();
    }

    public double getDifferenceY() {
        return points.get(0).getY() - points.get(1).getY();
    }

    public boolean hasPoint(int x, int y) {
        for(Point point : points) {
            if(point.isSame(x, y)) {
                return true;
            }
        }

        return false;
    }
}
