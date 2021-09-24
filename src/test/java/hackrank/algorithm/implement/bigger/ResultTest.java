package hackrank.algorithm.implement.bigger;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void biggerIsGreater_AlreadyGreatest_NoAnswer() {
        assertThat(Result.biggerIsGreater("aa")).isEqualTo("no answer");
        assertThat(Result.biggerIsGreater("cba")).isEqualTo("no answer");
        assertThat(Result.biggerIsGreater("ddddc")).isEqualTo("no answer");
    }

    @Test
    public void biggerIsGreater_HasGreater_ExpectedGreater() {
        assertThat(Result.biggerIsGreater("ab")).isEqualTo("ba");
        assertThat(Result.biggerIsGreater("baacde")).isEqualTo("baaced");
        assertThat(Result.biggerIsGreater("hcdk")).isEqualTo("hckd");
        assertThat(Result.biggerIsGreater("abacc")).isEqualTo("abcac");
    }
}
