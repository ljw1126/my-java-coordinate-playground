package coordinate.view;

import coordinate.model.Line;
import coordinate.model.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void createLine() {
        InputView inputView = new InputView();
        Line actual = inputView.create("(10,10)-(14,15)");

        Line expected = new Line(Arrays.asList(Point.of(10, 10), Point.of(14, 15)));
        assertThat(actual).isEqualTo(expected);
    }
}