package controller;

import model.Figure;
import view.InputView;
import view.OutputView;

public class CoordinateController {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Figure figure = inputView.input();

        outputView.draw(figure.getPoints());
        outputView.showResult(figure.result());
    }
}
