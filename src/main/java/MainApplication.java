import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.View.InputView;
import coordinate.View.OutputView;
import coordinate.model.Rectangular;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Point> points = InputView.scan();
        //Line line = new Line(points);
        Rectangular rectangular = new Rectangular(points);

        OutputView.draw(rectangular);
        System.out.println(OutputView.print());
        System.out.println(rectangular.getAreaInfo());
    }
}
