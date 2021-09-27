package hackrank.algorithm.implement.cavity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void cavityMap_HackerRankSampleInput_ExpectedCavities() {
        List<String> gridData = Arrays.asList(//@formatter:off
                "1112",
                "1912",
                "1892",
                "1234"
        );//@formatter:on

        List<String> gridCavities = Result.cavityMap(gridData);
        assertThat(gridCavities).containsExactly(//@formatter:off
                "1112",
                "1X12",
                "18X2",
                "1234"
        );//@formatter:on
    }

    @Test
    public void cavityMap_IgnoreCorners_ExpectedCavities() {
        List<String> gridData = Arrays.asList(//@formatter:off
                "818",
                "121",
                "818"
        );//@formatter:on

        List<String> gridCavities = Result.cavityMap(gridData);
        assertThat(gridCavities).containsExactly(//@formatter:off
                "818",
                "1X1",
                "818"
        );//@formatter:on
    }

    @Test
    public void cavityMap_NoCavities_SameGrid() {
        List<String> gridData = Arrays.asList(//@formatter:off
                "414",
                "650",
                "414"
        );//@formatter:on

        List<String> gridCavities = Result.cavityMap(gridData);
        assertThat(gridCavities).isEqualTo(gridData);
    }
}
