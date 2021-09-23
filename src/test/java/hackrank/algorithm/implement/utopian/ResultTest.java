package hackrank.algorithm.implement.utopian;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void utopianTree_ZeroCycles_InitialHeightOne() {
        int height = Result.utopianTree(0);
        assertThat(height).isEqualTo(1);
    }

    @Test
    public void utopianTree_OneCycle_HeightDouble() {
        int height = Result.utopianTree(1);
        assertThat(height).isEqualTo(2);
    }

    @Test
    public void utopianTree_TwoCycles_HeightDoublePlusOne() {
        int height = Result.utopianTree(2);
        assertThat(height).isEqualTo(3);
    }

    @Test
    public void utopianTree_FiveCycles_HeightFourteen() {
        int height = Result.utopianTree(5);
        assertThat(height).isEqualTo(14);
    }

}
