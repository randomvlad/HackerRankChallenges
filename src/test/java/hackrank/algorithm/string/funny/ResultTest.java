package hackrank.algorithm.string.funny;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void funnyString_AdjacentDiffSame_ReturnFunny() {
        String status = Result.funnyString("lmnop");
        assertThat(status).isEqualTo("Funny");
    }

    @Test
    void funnyString_AdjacentDiffNotSame_ReturnNotFunny() {
        String status = Result.funnyString("bcxz");
        assertThat(status).isEqualTo("Not Funny");
    }
}
