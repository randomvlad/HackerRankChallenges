package hackrank.algorithm.implement.angryprof;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void angryProfessor_TooManyLate_CancelClassYes() {
        int minStudentsRequired = 3;
        List<Integer> arrivalTimes = Arrays.asList(-1, -3, 4, 2);

        String cancelClassStatus = Result.angryProfessor(minStudentsRequired, arrivalTimes);
        assertThat(cancelClassStatus).isEqualTo("YES");
    }

    @Test
    public void angryProfessor_EnoughOnTime_CancelClassNo() {
        int minStudentsRequired = 4;
        List<Integer> arrivalTimes = Arrays.asList(5, -1, 0, -3, -2, 3);

        String cancelClassStatus = Result.angryProfessor(minStudentsRequired, arrivalTimes);
        assertThat(cancelClassStatus).isEqualTo("NO");
    }

    @Test
    public void angryProfessor_AllRequiredAndOnTime_CancelClassNo() {
        int minStudentsRequired = 5;
        List<Integer> arrivalTimes = Arrays.asList(-1, -2, 0, 0, -4);

        String cancelClassStatus = Result.angryProfessor(minStudentsRequired, arrivalTimes);
        assertThat(cancelClassStatus).isEqualTo("NO");
    }

    @Test
    public void angryProfessor_OnlyOneRequired_CancelClassNo() {
        int minStudentsRequired = 1;
        List<Integer> arrivalTimes = Arrays.asList(1, 2, 3, 4, 5, 0);

        String cancelClassStatus = Result.angryProfessor(minStudentsRequired, arrivalTimes);
        assertThat(cancelClassStatus).isEqualTo("NO");
    }
}
