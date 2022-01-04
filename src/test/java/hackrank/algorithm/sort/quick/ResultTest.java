package hackrank.algorithm.sort.quick;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void sort_SampleInput_SampleOutput() {
        List<String> steps = Result.sort(new int[] { 5, 8, 1, 3, 7, 9, 2 });
        assertThat(steps).containsExactly( //@formatter:off
                "2 3",
                "1 2 3",
                "7 8 9",
                "1 2 3 5 7 8 9"
        );//@formatter:on
    }

    @Test
    void sort_ReverseOrder_ExpectedResult() {
        List<String> steps = Result.sort(new int[] { 5, 4, 3, 2, 1 });
        assertThat(steps).containsExactly( //@formatter:off
                "1 2",
                "1 2 3",
                "1 2 3 4",
                "1 2 3 4 5"
        );//@formatter:on
    }

    @Test
    void sort_AlreadyOrdered_ExpectedResult() {
        List<String> steps = Result.sort(new int[] { 1, 2, 3, 4, 5 });
        assertThat(steps).containsExactly( //@formatter:off
                "4 5",
                "3 4 5",
                "2 3 4 5",
                "1 2 3 4 5"
        );//@formatter:on
    }
}
