package hackrank.algorithm.string.shergram;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void sherlockAndAnagrams_SingleChar_ZeroAnagramPairs() {
        int count = Result.sherlockAndAnagrams("v");
        assertThat(count).isEqualTo(0);
    }

    @Test
    void sherlockAndAnagrams_TwoSameChars_ZeroAnagramPairs() {
        int count = Result.sherlockAndAnagrams("vv");
        assertThat(count).isEqualTo(1);
    }

    @Test
    void sherlockAndAnagrams_ValueMom_TwoAnagramPairs() {
        int count = Result.sherlockAndAnagrams("mom");
        assertThat(count).isEqualTo(2);
    }

    @Test
    void sherlockAndAnagrams_ValueAbba_FourAnagramPairs() {
        int count = Result.sherlockAndAnagrams("abba");
        assertThat(count).isEqualTo(4);
    }

    @Test
    void sherlockAndAnagrams_ValueKkkk_TenAnagramPairs() {
        int count = Result.sherlockAndAnagrams("kkkk");
        assertThat(count).isEqualTo(10);
    }
}
