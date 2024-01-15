package coordinate.View;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void twoPointMatcher() {
        // given
        // when
        String given = "(0,0)-(24,24)";
        String regex = "^(\\([0-9]{1,2},[0-9]{1,2}\\))(-\\([0-9]{1,2},[0-9]{1,2}\\))$";
        Pattern pattern = Pattern.compile(regex);

        // then
        assertThat(pattern.matcher(given).find()).isTrue();
    }

    @Test
    void matchFindTest() {
        // given
        String given = "(0,0)-(24,24)";
        String regex = "(\\([0-9]{1,2},[0-9]{1,2}\\))";
        Pattern pattern = Pattern.compile(regex);

        // when
        Matcher matcher = pattern.matcher(given);
        int matchCount = 0;
        while(matcher.find()) {
            matchCount += 1;
            System.out.println(matcher.group());
        }

        // then
        assertThat(matchCount).isEqualTo(2);
    }

    @DisplayName("")
    @Test
    void groupCount() {
        // given
        // when
        String given = "(0,0)-(24,24)";
        String regex = "\\(([0-9]{1,2}),([0-9]{1,2})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);

        // then
        assertThat(matcher.groupCount()).isEqualTo(2);
    }

    @DisplayName("group(..)으로 원하는 좌표값을 파싱 가능하다")
    @Test
    void group() {
        // given
        // when
        String given = "(0,0)-(24,24)";
        String regex = "\\(([0-9]{1,2}),([0-9]{1,2})\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);

        // then
        matcher.find();
        assertThat(matcher.group()).isEqualTo("(0,0)");
        assertThat(matcher.group(0)).isEqualTo("(0,0)"); // 0번 인덱스는 전체 나타냄
        assertThat(matcher.group(1)).isEqualTo("0");
        assertThat(matcher.group(2)).isEqualTo("0");
        assertThat(matcher.groupCount()).isEqualTo(2); // 그래서 groupCount()호출시 -1 해준다

        matcher.find();
        assertThat(matcher.group()).isEqualTo("(24,24)");
        assertThat(matcher.group(0)).isEqualTo("(24,24)");
        assertThat(matcher.group(1)).isEqualTo("24");
        assertThat(matcher.group(2)).isEqualTo("24");
        assertThat(matcher.groupCount()).isEqualTo(2);
    }
}