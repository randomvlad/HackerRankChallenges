package hackrank.algorithm.bit.lonely;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void lonelyinteger_SingleNumberOnly_SingleNumberIsLonelyNumber() {
        int lonelyNumber = Result.lonelyinteger(Collections.singletonList(9));
        assertThat(lonelyNumber).isEqualTo(9);
    }

    @Test
    void lonelyinteger_HackerRankSampleInput2_SampleOutput2() {
        int lonelyNumber = Result.lonelyinteger(Arrays.asList(0, 0, 1, 2, 1));
        assertThat(lonelyNumber).isEqualTo(2);
    }
}
