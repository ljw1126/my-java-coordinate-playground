package coordinate;

import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.view.OutputView;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.draw(new Line(Arrays.asList(Point.of(10, 10), Point.of(2, 2))));
    }
}
