package hackrank.algorithm.sort.insert2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void insertionSortSteps_SampleInput_SampleOutput() {
        List<String> steps = Result.insertionSortSteps(Arrays.asList(3, 4, 7, 5, 6, 2, 1));
        assertThat(steps).containsExactly(//@formatter:off
                "3 4 7 5 6 2 1",
                "3 4 7 5 6 2 1",
                "3 4 5 7 6 2 1",
                "3 4 5 6 7 2 1",
                "2 3 4 5 6 7 1",
                "1 2 3 4 5 6 7"
        );//@formatter:on
    }

    @Test
    void insertionSortSteps_ReversedSort_InsertFirstPosition() {
        List<String> steps = Result.insertionSortSteps(Arrays.asList(5, 4, 3, 2, 1));

        assertThat(steps).containsExactly(//@formatter:off
                "4 5 3 2 1",
                "3 4 5 2 1",
                "2 3 4 5 1",
                "1 2 3 4 5"
        );//@formatter:on
    }

    @Test
    void insertionSortSteps_AlreadySorted_Unchanged() {
        List<String> steps = Result.insertionSortSteps(Arrays.asList(1, 2, 3, 4));

        assertThat(steps).containsExactly(//@formatter:off
                "1 2 3 4",
                "1 2 3 4",
                "1 2 3 4"
        );//@formatter:on
    }
}
