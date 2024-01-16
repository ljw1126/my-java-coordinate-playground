package coordinate.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineTest {



    @DisplayName("")
    @Test
    void distanceBetweenPoint() {
        // given
        // when
        Line line = new Line(Arrays.asList(new Point(10, 10), new Point(14, 15)));
        double distance = line.getDistance();

        // then
        assertThat(distance).isEqualTo(6.4, offset(0.1)); // 근사치 테스트
    }
}