package coordinate.view;

import coordinate.model.Line;
import coordinate.model.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_MESSAGE = "좌표를 입력하세요";
    private static final String INVALID_PATTERN = "올바른 좌표 형식을 입력해주세요";
    private static final String DUPLICATE_POINT = "중복 좌표가 존재 합니다";
    private static final Scanner sc = new Scanner(System.in);

    public Line inputCoordinate() {
        System.out.println(INPUT_MESSAGE);
        return create(sc.next());
    }

    public Line create(String input) {
        try {
            input = input.replaceAll(" ", "");
            checkValidPattern(input);
            List<Point> points = parsePoints(input);
            return new Line(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinate();
        }
    }

    private List<Point> parsePoints(String input) {
        Pattern pattern = Pattern.compile("\\((\\d{1,2}),(\\d{1,2})\\)");
        Matcher matcher = pattern.matcher(input);

        List<Point> points = new ArrayList<>();
        while(matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            points.add(Point.of(x, y));
        }

        checkDuplicatePoint(points);
        return points;
    }

    private void checkDuplicatePoint(List<Point> points) {
        if(points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException(DUPLICATE_POINT);
        }
    }

    private void checkValidPattern(String input) {
        Pattern pattern = Pattern.compile("\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)");
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_PATTERN);
        }
    }
}
