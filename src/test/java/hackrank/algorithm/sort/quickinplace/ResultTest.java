package hackrank.algorithm.sort.quickinplace;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void sort_SampleInput_SampleOutput() {
        List<String> steps = Result.sort(new int[] { 1, 3, 9, 8, 2, 7, 5 });
        assertThat(steps).containsExactly(//@formatter:off
                "1 3 2 5 9 7 8",
                "1 2 3 5 9 7 8",
                "1 2 3 4 7 8 9"
        );//@formatter:on
    }

    @Test
    void sort_ReverseOrder_ExpectedResult() {
        List<String> steps = Result.sort(new int[] { 5, 4, 3, 2, 1 });
        assertThat(steps).containsExactly( //@formatter:off
                "1 4 3 2 5", // "1" is put in place -> analyze "4 3 2 5" next
                "1 4 3 2 5", // "5" is put in place -> analyze "4 3 2" next
                "1 2 3 4 5", // "2" is put in place -> analyze "3 4" next
                "1 2 3 4 5" // "3" and "4" are put in place -> done
        );//@formatter:on
    }

    @Test
    void sort_AlreadyOrdered_ExpectedResult() {
        List<String> steps = Result.sort(new int[] { 1, 2, 3, 4, 5 });
        assertThat(steps).containsExactly( //@formatter:off
                "1 2 3 4 5", // "5" is put in place -> analyze "1 2 3 4" next
                "1 2 3 4 5", // "4" is put in place -> analyze "1 2 3" next
                "1 2 3 4 5", // "3" is put in place -> analyze "1 2" next
                "1 2 3 4 5" // "2" is put in place -> "1" becomes trivial and already in place
        );//@formatter:on
    }
}
