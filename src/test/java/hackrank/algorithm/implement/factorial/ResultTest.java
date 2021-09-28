package hackrank.algorithm.implement.factorial;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void calculateFactorial_Three_ResultSix() {
        BigInteger result = Result.calculateFactorial(3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void calculateFactorial_TwentyFive_ExpectedResult() {
        BigInteger result = Result.calculateFactorial(25);
        assertThat(result).isEqualTo(new BigInteger("15511210043330985984000000"));
    }
}
