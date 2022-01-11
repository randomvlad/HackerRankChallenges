package hackrank.algorithm.dynamic.maxsub;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void maxSubarray_AllPositive_SumOfEverything() {
        List<Integer> result = Result.maxSubarray(Arrays.asList(1, 2, 3, 4));
        assertThat(result).containsExactly(10, 10);
    }

    @Test
    void maxSubarray_Example_ExpectedMax() {
        List<Integer> result = Result.maxSubarray(Arrays.asList(-1, 2, 3, -4, 5, 10));
        assertThat(result).containsExactly(16, 20);
    }

    @Test
    void maxSubarray_AllNegative_PickMinNegative() {
        List<Integer> result = Result.maxSubarray(Arrays.asList(-20, -7, -99, -4));
        assertThat(result).containsExactly(-4, -4);
    }
}
