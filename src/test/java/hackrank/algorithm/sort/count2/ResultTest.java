package hackrank.algorithm.sort.count2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void countingSort_SimpleSequence_Sorted() {
        List<Integer> sorted = Result.countingSort(Arrays.asList(1, 2, 3, 2, 1));
        assertThat(sorted).hasSize(5).containsExactly(1, 1, 2, 2, 3);
    }
}
