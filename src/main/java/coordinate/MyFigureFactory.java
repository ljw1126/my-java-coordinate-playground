package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MyFigureFactory implements FigureCreator {
    private static final Map<Integer, Function<List<Point>, Figure>> instanceMap = new HashMap<>();

    static {
        instanceMap.put(Line.LINE_POINT_SIZE, Line::new);
        instanceMap.put(Triangle.TRIANGLE_POINT_SIZE, Triangle::new);
        instanceMap.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle::new);
    }

    @Override
    public Figure create(List<Point> points) {
        return instanceMap.get(points.size()).apply(points);
    }
}
