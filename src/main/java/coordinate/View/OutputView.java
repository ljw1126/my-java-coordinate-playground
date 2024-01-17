package coordinate.View;

import coordinate.model.Figure;

public class OutputView {
    private static final int MIN_LENGTH = 0;
    private static final int MAX_LENGTH = 24;
    private static final String DASH = "----";
    private static final String PIPELINE = "|";

    private static final String MARK_OF_POINT = "*";

    private static final String FOUR_BLANK = "    ";

    private static final String NEW_LINE = System.getProperty("line.separator");

    private static StringBuilder sb = new StringBuilder();

    public static void draw(Figure figure) {
        drawRowLine(figure);
        sb.append(FOUR_BLANK).append("+");
        drawHorizontalLine();
        drawHorizontalNumber();
    }

    private static void drawRowLine(Figure figure) {
        for(int y = MAX_LENGTH; y > MIN_LENGTH; y--) { // 24 ~ 1
            showRowNumber(y);

            sb.append(PIPELINE);

            markPoint(y, figure);

            sb.append(NEW_LINE);
        }
    }

    private static void markPoint(int y, Figure figure) {
        for(int x = MIN_LENGTH; x <= MAX_LENGTH; x++) {
            showMark(x, y, figure);
        }
    }

    private static void showMark(int x, int y, Figure figure) {
        if(figure.hasPoint(x, y)) {
            sb.append(String.format("%s", MARK_OF_POINT));
            return;
        }

        sb.append(FOUR_BLANK);
    }

    private static void showRowNumber(int row) {
        if(row % 2 == 0) {
            sb.append(String.format("%4d", row));
            return;
        }
        sb.append(FOUR_BLANK);
    }

    private static void drawHorizontalLine() {
        for(int x = MIN_LENGTH; x <= MAX_LENGTH; x++) {
            sb.append(DASH);
        }
        sb.append(NEW_LINE);
    }

    private static void drawHorizontalNumber() {
        for(int x = MIN_LENGTH; x <= MAX_LENGTH; x++) {
            showHorizontalNumber(x);
        }
        sb.append(NEW_LINE);
    }

    private static void showHorizontalNumber(int x) {
        if(x % 2 == 0) {
            sb.append(String.format("%4s", x));
            return;
        }
        sb.append(FOUR_BLANK);
    }

    public static String print() {
        return sb.toString();
    }
}
