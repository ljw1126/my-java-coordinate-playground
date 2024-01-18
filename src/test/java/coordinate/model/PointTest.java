package coordinate.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    void create() {
        Point point = Point.of(1, 1);

        assertThat(point).isEqualTo(Point.of(1, 1));
    }

    @Test
    void invalidPoint() {
        assertThatThrownBy(() -> Point.of(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Point.of(1, 25))
                .isInstanceOf(IllegalArgumentException.class);
    }
}