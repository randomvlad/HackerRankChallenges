package hackrank.algorithm.implement.stick;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void cutTheSticks_LinearDecrease_Expected() {
        List<Integer> stickLengths = Arrays.asList(4, 3, 2, 1);
        List<Integer> cutIterations = Result.cutTheSticks(stickLengths);
        assertThat(cutIterations).containsExactly(4, 3, 2, 1);
    }

    @Test
    public void cutTheSticks_AllOnes_OneIteration() {
        List<Integer> stickLengths = Arrays.asList(1, 1, 1, 1);
        List<Integer> cutIterations = Result.cutTheSticks(stickLengths);
        assertThat(cutIterations).containsExactly(4);
    }

    @Test
    public void cutTheSticks_HackerRankSampleInput0_ExpectedIterationCuts() {
        List<Integer> stickLengths = Arrays.asList(5, 4, 4, 2, 2, 8);
        List<Integer> cutIterations = Result.cutTheSticks(stickLengths);
        assertThat(cutIterations).containsExactly(6, 4, 2, 1);
    }
}
