package hackrank.algorithm.string.thrones;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void gameOfThrones_OneCharacterWithOddCount_ResultYes() {
        String result = Result.gameOfThrones("abbcc");
        assertThat(result).isEqualTo("YES");
    }

    @Test
    void gameOfThrones_MultipleCharactersWithOddCount_ResultNo() {
        String result = Result.gameOfThrones("abbccc");
        assertThat(result).isEqualTo("NO");
    }

    @Test
    void gameOfThrones_AllCharactersWithEvenCount_ResultYes() {
        String result = Result.gameOfThrones("aabbcc");
        assertThat(result).isEqualTo("YES");
    }
}
