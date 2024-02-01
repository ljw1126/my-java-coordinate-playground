package model;

import java.util.*;
import java.util.function.Function;

public class FigureFactory implements FigureCreator {

    private static final String DUPLICATE_POINT = "중복된 좌표가 포함되어 있습니다";

    private static final Map<Integer, Function<List<Point>, Figure>> createMap;
    static {
        createMap = new HashMap<>();
        createMap.put(Line.POINT_SIZE, Line::new);
        createMap.put(Rectangular.POINT_SIZE, Rectangular::new);
    }

    @Override
    public Figure create(List<Point> points) {
        checkDuplicatePoint(points);
        return createMap.get(points.size()).apply(points);
    }

    private static void  checkDuplicatePoint(List<Point> points) {
        int size = points.size();
        Set<Point> uniqueSet = new HashSet<>(points);

        if(size != uniqueSet.size()) {
            throw new IllegalStateException(DUPLICATE_POINT);
        }
    }
}
