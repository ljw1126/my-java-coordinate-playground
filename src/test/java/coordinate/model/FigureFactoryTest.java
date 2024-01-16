package coordinate.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FigureFactoryTest {
    private List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
    }

    @Test
    void exception_1포인트() {
        // given
        // when
        points.add(new Point(1, 1));
        // then

        Assertions.assertThatThrownBy(() -> {
            Figure figure = FigureFactory.create(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exception_5포인트() {
        // given
        // when
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(3, 3));
        points.add(new Point(4, 4));
        points.add(new Point(5, 5));

        // then
        Assertions.assertThatThrownBy(() -> {
            Figure figure = FigureFactory.create(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLine() {
        // given
        // when
        points.add(new Point(10, 10));
        points.add(new Point(14, 15));

        // then
        Assertions.assertThat(FigureFactory.create(points))
                .isInstanceOf(Line.class)
                .isEqualTo(new Line(points));
    }

    @Test
    void createRectangular() {
        // given
        // when
        points.add(new Point(10, 10));
        points.add(new Point(22, 10));
        points.add(new Point(22, 18));
        points.add(new Point(10, 18));

        // then
        Assertions.assertThat(FigureFactory.create(points))
                .isInstanceOf(Rectangular.class)
                .isEqualTo(new Rectangular(points));
    }
}