package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory implements FigureCreator {

    private static final Map<Integer, Function<List<Point>, Figure>> instanceMap = new HashMap<>();
    static {
        instanceMap.put(Line.NUM_OF_LINE, Line::new);
        instanceMap.put(Triangle.NUM_OF_TRIANGLE, Triangle::new);
        instanceMap.put(Rectangular.NUM_OF_RECTANGULAR, Rectangular::new);
    }

    @Override
    public Figure create(List<Point> points) {
        return instanceMap.get(points.size()).apply(points);
    }
}
