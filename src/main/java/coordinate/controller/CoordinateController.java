package coordinate.controller;

import coordinate.View.InputView;
import coordinate.View.OutputView;
import coordinate.model.Figure;
import coordinate.model.FigureFactory;

public class CoordinateController {

    public void run() {
        Figure figure = FigureFactory.create(InputView.scan());

        OutputView.draw(figure);
        System.out.println(OutputView.print());
        System.out.println(figure.getAreaInfo());
    }
}
