package coordinate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyFigureFactoryTest {

    @Test
    void line() {
        List<Point> points = Arrays.asList(Point.of(1, 2), Point.of(2, 3));
        Figure figure = new MyFigureFactory().create(points);

        assertThat(figure).isInstanceOf(Line.class);
        assertThat(figure.getName()).isEqualTo("선");
    }

    @Test
    void triangle() {
        List<Point> points = Arrays.asList(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4));
        Figure figure = new MyFigureFactory().create(points);

        assertThat(figure).isInstanceOf(Triangle.class);
        assertThat(figure.getName()).isEqualTo("삼각형");
    }

    @Test
    void rectangle() {
        List<Point> points = Arrays.asList(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4), Point.of(4, 4));
        Figure figure = new MyFigureFactory().create(points);

        assertThat(figure).isInstanceOf(Rectangle.class);
        assertThat(figure.getName()).isEqualTo("사각형");
    }
}