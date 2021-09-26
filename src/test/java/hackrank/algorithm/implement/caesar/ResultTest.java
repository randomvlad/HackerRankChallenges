package hackrank.algorithm.implement.caesar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void caesarCipher_RotateByThree_Expected() {
        String cipher = Result.caesarCipher("a-b-c", 3);
        assertThat(cipher).isEqualTo("d-e-f");
    }

    @Test
    public void caesarCipher_RotateInPlace_RotatedToOriginalValue() {
        String cipher = Result.caesarCipher("Tasty-Potato", Result.ALPHABET_ENGLISH_SIZE);
        assertThat(cipher).isEqualTo("Tasty-Potato");
    }

    @Test
    public void caesarCipher_RotateAndWrapAround_ExpectedWrap() {
        String cipher = Result.caesarCipher("xyz-XYZ", 3);
        assertThat(cipher).isEqualTo("abc-ABC");
    }

    @Test
    public void caesarCipher_HackerRankSampleInput_ExpectedSampleOutput() {
        String cipher = Result.caesarCipher("middle-Outz", 2);
        assertThat(cipher).isEqualTo("okffng-Qwvb");
    }
}
