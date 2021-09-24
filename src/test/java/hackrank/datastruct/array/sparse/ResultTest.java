package hackrank.datastruct.array.sparse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void matchingStrings_HackerRankSampleInput1_ExpectedCounts() {
        List<String> strings = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");
        List<Integer> counts = Result.matchingStrings(strings, queries);
        assertThat(counts).hasSize(3).containsExactly(2, 1, 0);
    }

    @Test
    public void matchingStrings_CatsAndDogsNoParrots_ExpectedCounts() {
        List<String> strings = Arrays.asList("cat", "dog", "dog", "cat", "cat", "cat");
        List<String> queries = Arrays.asList("dog", "parrot", "cat");
        List<Integer> counts = Result.matchingStrings(strings, queries);
        assertThat(counts).hasSize(3).containsExactly(2, 0, 4);
    }
}
