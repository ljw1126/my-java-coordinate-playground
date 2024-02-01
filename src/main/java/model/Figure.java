package model;

import java.util.List;

public interface Figure {
    List<Point> getPoints();

    String getAreaInfo();

    double getArea();

    boolean hasPoint(int x, int y);
}
