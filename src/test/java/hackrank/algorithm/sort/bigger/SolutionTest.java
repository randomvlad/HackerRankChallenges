package hackrank.algorithm.sort.bigger;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void findGreaterWord_AlreadyGreatest_Null() {
        assertThat(Solution.findGreaterWord("aa")).isNull();
        assertThat(Solution.findGreaterWord("cba")).isNull();
        assertThat(Solution.findGreaterWord("ddddc")).isNull();
    }

    @Test
    public void findGreaterWord_HasGreater_ExpectedGreater() {
        assertThat(Solution.findGreaterWord("ab")).isEqualTo("ba");
        assertThat(Solution.findGreaterWord("baacde")).isEqualTo("aedcba");
        assertThat(Solution.findGreaterWord("hcdk")).isEqualTo("dkhc");
        assertThat(Solution.findGreaterWord("abacc")).isEqualTo("aaccb");
    }
}
