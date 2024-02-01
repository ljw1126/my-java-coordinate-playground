package view;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String INPUT_MESSAGE = "좌표를 입력하세요.";
    private static final String INVALID_INPUT = "올바른 좌표 형식을 입력하세요";

    public InputView() {
    }

    public Figure input() {
        System.out.println(INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return process(sc);
    }

    private Figure process(Scanner sc) {
        try {
            String input = sc.next();

            invalidCoordinateInput(input);

            List<Point> points = parsePoints(input);

            return FigureFactory.create(points);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return input();
        }
    }

    private static List<Point> parsePoints(String input) {
        final String regexp = "\\((\\d{1,2}),(\\d{1,2})\\)";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);

        List<Point> result = new ArrayList<>();
        while(matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            result.add(new Point(x, y));
        }

        return result;
    }

    private void invalidCoordinateInput(String input) {
        final String regexp = "\\(\\d{1,2},\\d{1,2}\\)(-\\(\\d{1,2},\\d{1,2}\\)){1,3}";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);

        if(!matcher.find()) {
            throw new IllegalStateException(INVALID_INPUT);
        }
    }
}
