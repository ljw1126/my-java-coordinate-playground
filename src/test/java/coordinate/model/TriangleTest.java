package coordinate.model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    Figure figure;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(Point.of(10, 10), Point.of(14, 15), Point.of(20, 8));
        figure = new FigureFactory().create(points);
    }

    @Test
    void create() {
        assertThat(figure)
                .isInstanceOf(Triangle.class)
                .isEqualTo(new Triangle(Arrays.asList(Point.of(10, 10), Point.of(14, 15), Point.of(20, 8))));
    }


    @Test
    void area() {
        assertThat(figure.getArea()).isEqualTo(29.0, Offset.offset(0.1));
    }
}