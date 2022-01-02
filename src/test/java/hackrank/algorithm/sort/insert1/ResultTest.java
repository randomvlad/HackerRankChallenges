package hackrank.algorithm.sort.insert1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void insertionSortSteps_SampleInput_SampleOutput() {
        List<String> steps = Result.insertionSortSteps(Arrays.asList(1, 2, 4, 5, 3));

        assertThat(steps).containsExactly(//@formatter:off
                "1 2 4 5 5",
                "1 2 4 4 5",
                "1 2 3 4 5"
        );//@formatter:on
    }

    @Test
    void insertionSortSteps_ReversedSort_InsertFirstPosition() {
        List<String> steps = Result.insertionSortSteps(Arrays.asList(5, 4, 3, 2, 1));

        assertThat(steps).containsExactly(//@formatter:off
                "5 4 3 2 2",
                "5 4 3 3 2",
                "5 4 4 3 2",
                "5 5 4 3 2",
                "1 5 4 3 2"
        );//@formatter:on
    }

    @Test
    void insertionSortSteps_AlreadySorted_Unchanged() {
        List<String> steps = Result.insertionSortSteps(Arrays.asList(1, 2, 3, 4));

        assertThat(steps).containsExactly("1 2 3 4");
    }
}
