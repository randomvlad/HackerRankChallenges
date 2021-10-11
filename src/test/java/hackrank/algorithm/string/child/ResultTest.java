package hackrank.algorithm.string.child;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void commonChild_HarrySally_MaxChildLengthTwo() {
        int maxChildLength = Result.commonChild("HARRY", "SALLY");
        assertThat(maxChildLength).isEqualTo(2);
    }

    @Test
    void commonChild_NoCommonChars_NoPossibleChild() {
        int maxChildLength = Result.commonChild("aa", "bb");
        assertThat(maxChildLength).isEqualTo(0);
    }

    @Test
    void commonChild_IdenticalParents_ChildLengthEqualsParent() {
        int maxChildLength = Result.commonChild("aaa", "aaa");
        assertThat(maxChildLength).isEqualTo(3);
    }
}
