package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RectangularTest {

    @Test
    void exception() {
        List<Point> pointList = Arrays.asList(new Point(10, 10), new Point(24, 24));

        assertThatThrownBy(() -> new Rectangular(pointList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateArea() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18));
        Rectangular rectangular =  new Rectangular(points);

        double expected = 96.0;

        assertThat(rectangular.getArea()).isEqualTo(expected);
    }
}