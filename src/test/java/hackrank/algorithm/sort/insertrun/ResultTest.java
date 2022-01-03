package hackrank.algorithm.sort.insertrun;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void runningTime_SampleInput_SampleOutput() {
        int numberShifts = Result.runningTime(Arrays.asList(2, 1, 3, 1, 2));
        assertThat(numberShifts).isEqualTo(4);
    }

    @Test
    void runningTime_ReversedSort_ShiftAlways() {
        int numberShifts = Result.runningTime(Arrays.asList(5, 4, 3, 2, 1));
        assertThat(numberShifts).isEqualTo(10); // 1 + 2 + 3 + 4 -> (n)(n - 1) / 2 = 10
    }

    @Test
    void runningTime_AlreadySorted_Unchanged() {
        int numberShifts = Result.runningTime(Arrays.asList(1, 2, 3, 4));
        assertThat(numberShifts).isEqualTo(0);
    }
}
