import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.View.InputView;
import coordinate.View.OutputView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Point> points = InputView.scan();
        Line line = new Line(points);

        OutputView.draw(line);
        System.out.println(OutputView.print());
        System.out.println(line.toString());
    }
}
