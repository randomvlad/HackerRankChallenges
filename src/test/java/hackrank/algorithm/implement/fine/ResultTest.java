package hackrank.algorithm.implement.fine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void libraryFine_ReturnedBeforeDue_NoFine() {
        int fine = Result.libraryFine(27, 9, 2021, 1, 10, 2021);
        assertThat(fine).isEqualTo(0);
    }

    @Test
    public void libraryFine_ReturnedLateDifferentYear_MaxFine() {
        int fine = Result.libraryFine(17, 4, 2022, 1, 10, 2021);
        assertThat(fine).isEqualTo(10000);
    }

    @Test
    public void libraryFine_ReturnedLateDifferentMonth_FinePerMonthLate() {
        int fine = Result.libraryFine(17, 8, 2021, 1, 4, 2021);
        assertThat(fine).isEqualTo(2000);
    }

    @Test
    public void libraryFine_ReturnedLateSameMonth_FinePerDayLate() {
        int fine = Result.libraryFine(11, 10, 2021, 1, 10, 2021);
        assertThat(fine).isEqualTo(150);
    }
}
