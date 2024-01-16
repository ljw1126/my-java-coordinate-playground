package coordinate.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RectangularTest {

    Rectangular rectangular = null;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18));
        rectangular = new Rectangular(points);
    }

    @Test
    void getArea() {
        // given
        // when
        double area = rectangular.getArea();

        // then
        assertThat(area).isEqualTo(96);
    }

    @Test
    void getAreaInfo() {
        // given
        // when
        String result = rectangular.getAreaInfo();

        // then
        assertThat(result).isEqualTo("직사각형의 넓이는 96.0");
    }

    @Test
    void hasPoint() {
        // given
        // when
        // then
        assertThat(rectangular.hasPoint(10, 10)).isTrue();
        assertThat(rectangular.hasPoint(24, 24)).isFalse();
    }


    @AfterEach
    void tearDown() {
        rectangular = null;
    }
}