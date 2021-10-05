package hackrank.algorithm.string.pangram;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void pangrams_EveryLetterPresent_Pangram() {
        String status = Result.pangrams("We promptly judged antique ivory buckles for the next prize");
        assertThat(status).isEqualTo("pangram");
    }

    @Test
    void pangrams_NotEveryLetterPresent_NotPangram() {
        String status = Result.pangrams("We promptly judged antique ivory buckles for the prize");
        assertThat(status).isEqualTo("not pangram");
    }
}
