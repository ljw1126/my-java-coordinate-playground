package coordinate.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.data.Offset.offset;

class LineTest {

    private Figure figure;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(Point.of(10, 10), Point.of(14, 15));
        figure = new FigureFactory().create(points);
    }

    @Test
    void create() {
        assertThat(figure)
                .isInstanceOf(Line.class)
                .isEqualTo(new Line(Arrays.asList(Point.of(10, 10), Point.of(14, 15))));
    }

    @Test
    void distance() {
        double distance = figure.getArea();

        assertThat(distance).isEqualTo(6.4, offset(0.1));
    }

    @Test
    void result() {
        double distance = figure.getArea();
        String resultMessage = figure.getAreaInfo();

        assertThat(resultMessage).isEqualTo("두 점 사이의 거리는 " + distance);
    }

    @Test
    void line_만들려면_두점이필요합니다() {
        assertThatThrownBy(() -> new Line(Arrays.asList(Point.of(1, 1))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void tearDown() {
        figure = null;
    }
}