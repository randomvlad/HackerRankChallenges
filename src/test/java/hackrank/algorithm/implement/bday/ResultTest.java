package hackrank.algorithm.implement.bday;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void taumBday_EqualCostNoConvertAdvantage_BuyDirectNoConvert() {
        long cost = Result.taumBday(10, 10, 1, 1, 1);
        assertThat(cost).isEqualTo(20);
    }

    @Test
    public void taumBday_WhiteGiftCheaperConvertAdvantage_BuyOnlyWhiteAndConvert() {
        long cost = Result.taumBday(3, 6, 9, 1, 1);
        assertThat(cost).isEqualTo(12);
    }

    @Test
    public void taumBday_BlackGiftCheaperConvertAdvantage_BuyOnlyBlackAndConvert() {
        long cost = Result.taumBday(4, 4, 1, 9, 2);
        assertThat(cost).isEqualTo(16);
    }
}
