package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RectangularTest {

    @Test
    void area() {
        List<Point> points = Arrays.asList(Point.of(10, 10), Point.of(22, 10), Point.of(22, 18), Point.of(10, 18));
        Rectangular rectangular = new Rectangular(points);

        assertThat(rectangular.getArea()).isEqualTo(96.0);
    }

}