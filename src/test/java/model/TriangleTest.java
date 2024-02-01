package model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    @Test
    void create() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8));
        Figure figure = new FigureFactory().create(points);

        assertThat(figure).isInstanceOf(Triangle.class);
    }

    @Test
    void calculateArea() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8));
        Triangle triangle = new Triangle(points);

        double actual = triangle.getArea();
        double expected = 29.0;

        assertThat(actual).isEqualTo(expected, Offset.offset(0.1));
    }
}