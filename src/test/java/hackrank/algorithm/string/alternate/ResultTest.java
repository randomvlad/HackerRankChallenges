package hackrank.algorithm.string.alternate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void alternatingCharacters_ThreeA_TwoDeletions() {
        int deletions = Result.alternatingCharacters("AAA");
        assertThat(deletions).isEqualTo(2);
    }

    @Test
    void alternatingCharacters_AlreadyAlternating_ZeroDeletions() {
        int deletions = Result.alternatingCharacters("ABABABA");
        assertThat(deletions).isEqualTo(0);
    }

    @Test
    void alternatingCharacters_ThreeAThreeB_FourDeletions() {
        int deletions = Result.alternatingCharacters("AAABBB");
        assertThat(deletions).isEqualTo(4);
    }
}
