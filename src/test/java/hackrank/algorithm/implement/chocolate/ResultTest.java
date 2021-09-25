package hackrank.algorithm.implement.chocolate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void chocolateFeast_HackerRankSampleInput_ExpectedTotal() {
        int totalEaten = Result.chocolateFeast(10, 2, 5);
        assertThat(totalEaten).isEqualTo(6);
    }

    @Test
    public void chocolateFeast_NotEnoughWrappersForExchange_ExpectedTotal() {
        int totalEaten = Result.chocolateFeast(12, 3, 10);
        assertThat(totalEaten).isEqualTo(4);
    }

    @Test
    public void chocolateFeast_MultipleWrapperExchanges_ExpectedTotal() {
        int totalEaten = Result.chocolateFeast(15, 3, 2);
        assertThat(totalEaten).isEqualTo(9);
    }
}
