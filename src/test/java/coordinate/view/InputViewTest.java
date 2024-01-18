package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.model.Rectangular;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void createLine() {
        InputView inputView = new InputView();
        Figure actual = inputView.create("(10,10)-(14,15)");

        Line expected = new Line(Arrays.asList(Point.of(10, 10), Point.of(14, 15)));
        assertThat(actual)
                .isInstanceOf(Line.class)
                .isEqualTo(expected);
    }

    @Test
    void createRectangular() {
        InputView inputView = new InputView();
        Figure actual = inputView.create("(10,10)-(22,10)-(22,18)-(10,18)");

        Rectangular expected = new Rectangular(Arrays.asList(Point.of(10, 10), Point.of(22, 10), Point.of(22, 18), Point.of(10, 18)));
        assertThat(actual)
                .isInstanceOf(Rectangular.class)
                .isEqualTo(expected);
    }
}