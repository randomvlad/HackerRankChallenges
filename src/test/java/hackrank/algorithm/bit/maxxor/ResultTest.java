package hackrank.algorithm.bit.maxxor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void maximizingXor_Between10And15_Max7() {
        int max = Result.maximizingXor(10, 15);
        assertThat(max).isEqualTo(7);
    }

    @Test
    void maximizingXor_SingleNumber_MaxZero() {
        int max = Result.maximizingXor(100, 100);
        assertThat(max).isEqualTo(0);
    }
}
