package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 1. 상수로 직접 지정하지 말고 의미 있는 변수명 부여해서 사용하자
 * 2. Figure 생성시 중복 포인트 검사는 자식 클래스에서 책임지도록 하자
 */
public class FigureFactory {
    private static final String CREATE_EXCEPTION_MESSAGE = "데이터가 올바르지 않습니다";
    private static final int MIN_POINT_SIZE = 2;
    private static final int MAX_POINT_SIZE = 4;
    private static final int NUM_OF_LINE = 2;
    private static final int NUM_OF_RECTANGULAR = 4;

    private static final Map<Integer, Function<List<Point>, Figure>> factoryMap;
    static {
        factoryMap = new HashMap<>();
        factoryMap.put(NUM_OF_LINE, Line::new);
        factoryMap.put(NUM_OF_RECTANGULAR, Rectangular::new);
    }

    public static Figure create(List<Point> points) {
        if(points == null) {
            throw new IllegalArgumentException(AbstractFigure.ERROR_FIGURE_NULL);
        }

        if(checkInValidSize(points.size())) {
            throw new IllegalArgumentException(CREATE_EXCEPTION_MESSAGE);
        }

        return factoryMap.get(points.size()).apply(points);
    }

    private static boolean checkInValidSize(int size) {
        return size < MIN_POINT_SIZE || MAX_POINT_SIZE < size;
    }
}
