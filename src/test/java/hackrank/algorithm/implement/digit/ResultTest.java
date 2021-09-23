package hackrank.algorithm.implement.digit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void findDigits_OneTwoSeven_OnlyOneDivisor() {
        int count = Result.findDigits(127);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void findDigits_OneTwo_AllDivisors() {
        int count = Result.findDigits(12);
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void findDigits_OneZeroOneTwo_AllDivisorsExceptZero() {
        int count = Result.findDigits(1012);
        assertThat(count).isEqualTo(3);
    }
}
