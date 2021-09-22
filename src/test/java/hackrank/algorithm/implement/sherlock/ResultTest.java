package hackrank.algorithm.implement.sherlock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void findDecentNumber_LengthOne_NoDecentNumberExists() {
        String decentNumber = Result.findDecentNumber(1);
        assertThat(decentNumber).isEqualTo("-1");
    }

    @Test
    public void findDecentNumber_LengthThree_SingleBlockDecentFives() {
        String decentNumber = Result.findDecentNumber(3);
        assertThat(decentNumber).isEqualTo("555");
    }

    @Test
    public void findDecentNumber_LengthFive_SingleBlockDecentThrees() {
        String decentNumber = Result.findDecentNumber(5);
        assertThat(decentNumber).isEqualTo("33333");
    }

    @Test
    public void findDecentNumber_LengthTen_TwoBlocksDecentThrees() {
        String decentNumber = Result.findDecentNumber(10);
        assertThat(decentNumber).isEqualTo("3333333333");
    }

    @Test
    public void findDecentNumber_LengthEleven_OneBlockDecentFivesOneBlockDecentThrees() {
        String decentNumber = Result.findDecentNumber(11);
        assertThat(decentNumber).isEqualTo("55555533333");
    }
}
