package hackrank.algorithm.implement.squares;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void squares_Range1to1_InRange1Square() {
        int count = Result.squares(1, 1);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void squares_Range3to9_InRange2Squares() {
        int count = Result.squares(3, 9);
        assertThat(count).isEqualTo(2); // 4 and 9
    }

    @Test
    public void squares_Range1to100_InRange10Squares() {
        int count = Result.squares(1, 100);
        assertThat(count).isEqualTo(10); // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    }
}
