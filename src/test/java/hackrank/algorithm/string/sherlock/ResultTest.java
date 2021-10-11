package hackrank.algorithm.string.sherlock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void isValid_EveryCharAppearsOnce_ResultYes() {
        String result = Result.isValid("abc");
        assertThat(result).isEqualTo("YES");
    }

    @Test
    void isValid_OneExtraChar_ResultYes() {
        String result = Result.isValid("aabbccc");
        assertThat(result).isEqualTo("YES");
    }

    @Test
    void isValid_TwoExtraChars_ResultNo() {
        String result = Result.isValid("abcddee");
        assertThat(result).isEqualTo("NO");
    }
}
