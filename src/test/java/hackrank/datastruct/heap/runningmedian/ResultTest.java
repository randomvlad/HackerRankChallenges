package hackrank.datastruct.heap.runningmedian;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void runningMedian_HackerRankExample_ExpectedMedians() {
        List<Integer> numbers = Arrays.asList(12, 4, 5, 3, 8, 7);
        List<Double> medians = Result.runningMedian(numbers);
        assertThat(medians).hasSize(6).containsExactly(12.0, 8.0, 5.0, 4.5, 5.0, 6.0);
    }

    @Test
    public void runningMedian_Increasing_ExpectedMedians() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> medians = Result.runningMedian(numbers);
        assertThat(medians).hasSize(5).containsExactly(1.0, 1.5, 2.0, 2.5, 3.0);
    }
}
