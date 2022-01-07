package hackrank.algorithm.sort.count1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void countingSort_SampleInput_SampleOutput() {
        List<Integer> counts = Result.countingSort(Arrays.asList(1, 2, 3, 4, 1));

        // check only first 10, rest will be 0s
        assertThat(counts).hasSize(100).startsWith(0, 2, 1, 1, 1, 0, 0, 0, 0, 0);
    }
}
