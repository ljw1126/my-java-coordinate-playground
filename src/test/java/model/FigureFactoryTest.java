package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FigureFactoryTest {

    @Test
    void createLine() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15));
        FigureFactory figureFactory = new FigureFactory();
        Figure figure = figureFactory.create(points);

        assertThat(figure).isInstanceOf(Line.class);
    }

    @Test
    void createRectangular() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18));
        FigureFactory figureFactory = new FigureFactory();
        Figure figure = figureFactory.create(points);

        assertThat(figure).isInstanceOf(Rectangular.class);
    }
}