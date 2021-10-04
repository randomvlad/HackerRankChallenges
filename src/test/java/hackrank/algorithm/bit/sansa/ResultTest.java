package hackrank.algorithm.bit.sansa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void sansaXor_Numbers123_Xor2() {
        int result = Result.sansaXor(Arrays.asList(1, 2, 3));
        assertThat(result).isEqualTo(2);
    }

    @Test
    void sansaXor_Numbers4575_Xor0() {
        int result = Result.sansaXor(Arrays.asList(4, 5, 7, 5));
        assertThat(result).isZero();
    }
}
