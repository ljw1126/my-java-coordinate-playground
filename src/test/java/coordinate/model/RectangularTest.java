package coordinate.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RectangularTest {

    Figure figure;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(Point.of(10, 10), Point.of(22, 10), Point.of(22, 18), Point.of(10, 18));
        figure = new FigureFactory().create(points);
    }

    @Test
    void create() {
        assertThat(figure)
                .isInstanceOf(Rectangular.class)
                .isEqualTo(new Rectangular(Arrays.asList(Point.of(10, 10), Point.of(22, 10), Point.of(22, 18), Point.of(10, 18))));
    }

    @Test
    void area() {
        assertThat(figure.getArea()).isEqualTo(96.0);
    }

}