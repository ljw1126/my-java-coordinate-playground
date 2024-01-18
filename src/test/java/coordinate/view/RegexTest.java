package coordinate.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class RegexTest {

    @Test
    void regexMatch() {
        String input = "(10,10)-(14,15)";
        String regex = "\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        assertThat(matcher.find()).isTrue();
    }

    @Test
    void group() {
        String input = "(10,11)-(14,15)";
        String regex = "\\((\\d{1,2}),(\\d{1,2})\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int groupCount = matcher.groupCount();
        assertThat(groupCount).isEqualTo(2);

        matcher.find();
        assertThat(matcher.group()).isEqualTo("(10,11)"); // group() == group(0)
        assertThat(matcher.group(1)).isEqualTo("10");
        assertThat(matcher.group(2)).isEqualTo("11");

        matcher.find();
        assertThat(matcher.group()).isEqualTo("(14,15)");
        assertThat(matcher.group(1)).isEqualTo("14");
        assertThat(matcher.group(2)).isEqualTo("15");
    }
}
