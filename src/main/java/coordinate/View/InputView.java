package coordinate.View;

import coordinate.Point;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_COORDINATE = "좌표를 입력하세요";
    private static final String INPUT_FORMAT = "올바른 좌표 형식으로 입력하세요";

    private static final String INPUT_DUPLICATE = "중복된 좌표 값이 존재합니다";
    private static Scanner scanner = new Scanner(System.in);
    private static final String HYPHEN = "-";

    public static List<Point> scan() {
        System.out.println(INPUT_COORDINATE);
        return getPoints(scanner.next());
    }

    private static List<Point> getPoints(String input) {
        try {
            input = input.replaceAll(" ", "");
            // 정규식으로 유효성 검사
            checkInputFormat(input);
            return getPointList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scan();
        }
    }

    private static List<Point> getPointList(String input) {
        String[] tokens = input.split(HYPHEN);

        List<Point> points = new ArrayList<>();
        for(String token : tokens) {
            points.add(parsePoint(token));
        }

        checkDuplicatePoint(points);
        return points;
    }

    private static void checkDuplicatePoint(List<Point> points) {
        if(points.size() != new HashSet(points).size()) {
            throw new IllegalArgumentException(INPUT_DUPLICATE);
        }
    }

    private static Point parsePoint(String input) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Point(x, y);
        }

        throw new IllegalArgumentException(INPUT_FORMAT);
    }

    private static void checkInputFormat(String input) {
        Pattern pattern = Pattern.compile("^(\\([0-9]{1,2},[0-9]{1,2}\\))(-\\([0-9]{1,2},[0-9]{1,2}\\))$");

        if(!pattern.matcher(input).find()) {
            throw new IllegalArgumentException(INPUT_FORMAT);
        }
    }

}
