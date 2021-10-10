package hackrank.algorithm.string.palindrome;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void palindromeIndex_AlreadyPalindrome_NoSolution() {
        int index = Result.palindromeIndex("aa");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void palindromeIndex_NoPalindromePossible_NoSolution() {
        int index = Result.palindromeIndex("abc");
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void palindromeIndex_AlmostPalindrome_RemoveFirstChar() {
        int index = Result.palindromeIndex("baa");
        assertThat(index).isEqualTo(0);
    }

    @Test
    void palindromeIndex_AlmostPalindrome_RemoveLastChar() {
        int index = Result.palindromeIndex("aaab");
        assertThat(index).isEqualTo(3);
    }
}
