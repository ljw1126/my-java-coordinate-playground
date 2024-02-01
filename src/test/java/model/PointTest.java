package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    void exception() {
        assertThatThrownBy(() -> new Point(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Point(24, 25))
                .isInstanceOf(IllegalArgumentException.class);
    }
}