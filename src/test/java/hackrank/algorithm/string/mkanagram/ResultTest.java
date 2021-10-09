package hackrank.algorithm.string.mkanagram;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void makingAnagrams_AlreadyAnagram_ZeroDeletions() {
        int deletions = Result.makingAnagrams("abc", "cba");
        assertThat(deletions).isEqualTo(0);
    }

    @Test
    void makingAnagrams_OnlyOneCharSame_DeleteAllButSameChar() {
        int deletions = Result.makingAnagrams("cde", "abc");
        assertThat(deletions).isEqualTo(4);
    }
}
