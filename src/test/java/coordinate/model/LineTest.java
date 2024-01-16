package coordinate.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineTest {

    Line line = null;

    @BeforeEach
    void setUp() {
        line = new Line(Arrays.asList(new Point(10, 10), new Point(14, 15)));
    }

    @Test
    void hasPoint() {
        // given
        // when
        // then
        assertThat(line.hasPoint(10, 10)).isTrue();
        assertThat(line.hasPoint(24, 24)).isFalse();
    }

    @Test
    void getArea() {
        // given
        // when
        double distance = line.getArea();

        // then
        assertThat(distance).isEqualTo(6.4, offset(0.1)); // 근사치 테스트
    }

    @AfterEach
    void tearDown() {
        line = null;
    }
}