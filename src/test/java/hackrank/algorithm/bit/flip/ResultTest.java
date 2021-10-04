package hackrank.algorithm.bit.flip;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void flippingBits_MaxNumber_Zero() {
        long flipped = Result.flippingBits(2147483647L);
        assertThat(flipped).isEqualTo(2147483648L);
    }

    @Test
    void flippingBites_Max_Zero() {
        long flipped = Result.flippingBits(Result.MAX_32_BIT_UNSIGNED);
        assertThat(flipped).isZero();
    }

    @Test
    void flippingBites_MaxInt_MaxIntPlusOne() {
        long flipped = Result.flippingBits(Integer.MAX_VALUE);
        assertThat(flipped).isEqualTo((long) Integer.MAX_VALUE + 1);
    }
}
