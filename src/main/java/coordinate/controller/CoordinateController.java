package coordinate.controller;

import coordinate.model.Figure;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateController {

    public void run() {
        InputView inputView = new InputView();
        Figure figure = inputView.inputCoordinate();

        OutputView outputView = new OutputView();
        outputView.draw(figure);
        outputView.printInfo(figure);
    }
}
