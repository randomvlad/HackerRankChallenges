package hackrank.algorithm.string.anagram;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void anagram_AlreadyAnagram_ZeroChanges() {
        int changes = Result.anagram("abccba");
        assertThat(changes).isEqualTo(0);
    }

    @Test
    void anagram_OddLength_NotPossible() {
        int changes = Result.anagram("abc");
        assertThat(changes).isEqualTo(-1);
    }

    @Test
    void anagram_ChangeAllLeftOrRight_ThreeChanges() {
        int changes = Result.anagram("aaabbb");
        assertThat(changes).isEqualTo(3);
    }

    @Test
    void anagram_NeedsFive_FiveChanges() {
        int changes = Result.anagram("fdhlvosfpafhalll");
        assertThat(changes).isEqualTo(5);
    }
}
