package model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void exception() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(24, 24));
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateDistance() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15));
        Line line = new Line(points);
        double distance = line.calculateDistance();

        double expected = 6.4;

        assertThat(distance).isEqualTo(expected, Offset.offset(0.1));
    }
}