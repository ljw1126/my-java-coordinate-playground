package controller;

import model.Line;
import view.InputView;
import view.OutputView;

public class CoordinateController {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Line line = new Line(inputView.input());

        outputView.draw(line.getPoints());
        outputView.showResult(line.result());
    }
}
