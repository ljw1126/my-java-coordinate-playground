package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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
    
    public List<Integer> getDistinctPoint(Function<Point, Integer> mapFunction) {
        return this.points.stream()
                .map(mapFunction)
                .distinct()
                .collect(toList());
    }
}
