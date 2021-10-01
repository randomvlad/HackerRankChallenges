package hackrank.algorithm.implement.time;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void timeInWords_HackerRankSampleInput0_SampleOutput0() {
        String timeInWords = Result.timeInWords(5, 47);
        assertThat(timeInWords).isEqualTo("thirteen minutes to six");
    }

    @Test
    void timeInWords_HackerRankSampleInput1_SampleOutput1() {
        String timeInWords = Result.timeInWords(3, 0);
        assertThat(timeInWords).isEqualTo("three o' clock");
    }

    @Test
    void timeInWords_HackerRankSampleInput2_SampleOutput2() {
        String timeInWords = Result.timeInWords(7, 15);
        assertThat(timeInWords).isEqualTo("quarter past seven");
    }
}
