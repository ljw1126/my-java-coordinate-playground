package coordinate.controller;

import coordinate.model.Line;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateController {

    public void run() {
        InputView inputView = new InputView();
        Line line = inputView.inputCoordinate();

        OutputView outputView = new OutputView();
        outputView.draw(line);
        outputView.printInfo(line);
    }
}
