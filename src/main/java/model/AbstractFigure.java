package model;

import java.util.List;

public abstract class AbstractFigure implements Figure {

    protected final Points points;

    public AbstractFigure(List<Point> points) {
        this.points = new Points(points);
    }

    protected double abs(double value) {
        return Math.abs(value);
    }

    protected double pow(double value) {
        return Math.pow(value, 2);
    }

    protected double sqrt(double value) {
        return Math.sqrt(value);
    }

}
