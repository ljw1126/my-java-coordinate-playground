package model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 두점의기울기가수직인경우_예외를발생시킨다() {
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(1, 3), new Point(1, 24));
        assertThatThrownBy(() -> new Triangle(points))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 두점의기울기가수평인경우_예외를발생시킨다() {
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(10, 1), new Point(10, 1));
        assertThatThrownBy(() -> new Triangle(points))
                .isInstanceOf(IllegalStateException.class);
    }
}