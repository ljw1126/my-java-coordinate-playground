package coordinate.view;

import coordinate.model.Line;

public class OutputView {

    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 24;
    private static final String NEW_LINE = System.lineSeparator();
    private static final String PIPELINE = "|";
    private static final String FOUR_BLACK = "    ";
    private static final String PLUS_MARK = "+";
    private static final String POINT_MARK = "*";
    private static final String FOUR_DASH = "----";


    private final StringBuilder sb = new StringBuilder();
    public void draw(Line line) {
        showVertical(line);
        showHorizontal();
        showHorizontalPoint();

        System.out.println(sb.toString());
    }

    private void showHorizontalPoint() {
        sb.append(FOUR_BLACK);
        for(int x = MIN_POSITION + 1; x <= MAX_POSITION; x++) {
            if(x % 2 == 0) {
                sb.append(String.format("%4s", x));
                continue;
            }
            sb.append(FOUR_BLACK);
        }
    }

    private void showHorizontal() {
        sb.append(FOUR_BLACK).append(PLUS_MARK);
        for(int x = MIN_POSITION; x <= MAX_POSITION; x++) {
            sb.append(FOUR_DASH);
        }
        sb.append(NEW_LINE);
    }

    private void showVertical(Line line) {
        for(int y = MAX_POSITION; y > MIN_POSITION; y--) {
            drawVerticalAxis(y);
            drawPoint(y, line);
            sb.append(NEW_LINE);
        }
    }

    private void drawPoint(int y, Line line) {
        for(int x = MIN_POSITION; x <= MAX_POSITION; x++) {
            if(line.hasPoint(x, y)) {
                sb.append(String.format("%s", POINT_MARK));
                continue;
            }
            sb.append(FOUR_BLACK);
        }
    }

    private void drawVerticalAxis(int y) {
        if(y % 2 == 0) {
            sb.append(String.format("%4s", y));
            sb.append(PIPELINE);
            return;
        }

        sb.append(FOUR_BLACK).append(PIPELINE);
    }

    public void printInfo(Line line) {
        System.out.println(line.getResult());
    }
}
