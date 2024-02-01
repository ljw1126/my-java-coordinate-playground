import model.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexpTest {

    private final String matchRegexp = "\\(\\d{1,2},\\d{1,2}\\)(-\\(\\d{1,2},\\d{1,2}\\)){1,3}";
    private final String parseRegexp = "\\((\\d{1,2}),(\\d{1,2})\\)";

    private static Stream<Arguments> getTestDataProvider() {
        return Stream.of(
                Arguments.arguments("(10,10)-(14,15)",
                        Arrays.asList(new Point(10, 10), new Point(14, 15))),
                Arguments.arguments("(10,10)-(22,10)-(22,18)-(10,18)",
                        Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18))),
                Arguments.arguments("(10,10)-(14,15)-(20,8)",
                        Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8)))
        );
    }

    @ParameterizedTest
    @MethodSource("getTestDataProvider")
    void find(String givenInput, List<Point> expected) {
        Pattern pattern = Pattern.compile(matchRegexp);
        Matcher matcher = pattern.matcher(givenInput);

        assertThat(matcher.find()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("getTestDataProvider")
    void groupAndParse(String givenInput, List<Point> expected) {
        Pattern pattern = Pattern.compile(parseRegexp);
        Matcher matcher = pattern.matcher(givenInput);

        List<Point> actual = new ArrayList<>();
        while(matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            actual.add(new Point(x, y));
        }

        assertThat(actual).isEqualTo(expected);
    }
}
