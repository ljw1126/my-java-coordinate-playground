package coordinate;

import coordinate.model.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    void create() {
        // given
        // when
        Point point = new Point(10, 10);

        // then
        assertThat(point).isEqualTo(new Point(10, 10));
    }

    @Test
    void exceptionPointX() {
        assertThatThrownBy(() -> {
            Point point = new Point(25, 0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x 좌표는 0 ~ 24까지만 입력 가능합니다");
    }

    @Test
    void exceptionPointY() {
        assertThatThrownBy(() -> {
            Point point = new Point(0, 25);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("y좌표 값은 0 ~ 24까지 입력 가능합니다");
    }
}