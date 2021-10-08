package hackrank.algorithm.string.two;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void twoStrings_ShareCommonCharacter_HasSubstring() {
        String substringStatus = Result.twoStrings("and", "art");
        assertThat(substringStatus).isEqualTo("YES");
    }

    @Test
    void twoStrings_NoSharedCharacter_NoSubstring() {
        String substringStatus = Result.twoStrings("be", "cat");
        assertThat(substringStatus).isEqualTo("NO");
    }
}
