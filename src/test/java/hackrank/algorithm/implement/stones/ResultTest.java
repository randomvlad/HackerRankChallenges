package hackrank.algorithm.implement.stones;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void stones_HackerRankCase1_ExpectedLastValues() {
        List<Integer> possibleLastValues = Result.stones(3, 1, 2);
        assertThat(possibleLastValues).containsExactly(2, 3, 4);
    }

    @Test
    public void stones_HackerRankCase2_ExpectedLastValues() {
        List<Integer> possibleLastValues = Result.stones(4, 10, 100);
        assertThat(possibleLastValues).containsExactly(30, 120, 210, 300);
    }
}
