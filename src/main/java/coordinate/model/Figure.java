package coordinate.model;

import java.util.List;

public interface Figure {
    List<Point> getPoint();
    boolean hasPoint(int x, int y);
    double getArea();
    String getAreaInfo();
}
