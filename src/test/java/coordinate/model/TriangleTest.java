package coordinate.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TriangleTest {

    @Test
    void area() {
        // given
        // when
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8));
        Triangle triangle = new Triangle(points);

        // then
        Assertions.assertThat(triangle.getArea()).isEqualTo(29.0, Offset.offset(0.1));
    }
}