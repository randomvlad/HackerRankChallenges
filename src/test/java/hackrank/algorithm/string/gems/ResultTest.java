package hackrank.algorithm.string.gems;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void gemstones_TwoCharsPresentInAllStrings_TwoGemstones() {
        int gemstones = Result.gemstones(Arrays.asList("abc", "abc", "bc"));
        assertThat(gemstones).isEqualTo(2);
    }

    @Test
    void gemstones_NoCharsPresentInAllStrings_ZeroGemstones() {
        int gemstones = Result.gemstones(Arrays.asList("abc", "def", "xyz"));
        assertThat(gemstones).isEqualTo(0);
    }

    @Test
    void gemstones_OneStringOnly_EveryCharGemstone() {
        int gemstones = Result.gemstones(Collections.singletonList("ab"));
        assertThat(gemstones).isEqualTo(2);
    }
}
