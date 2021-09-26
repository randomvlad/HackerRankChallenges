package hackrank.algorithm.implement.grid;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void gridSearch_PatternMatches_FoundYes() {
        List<String> gridData = Arrays.asList("2288", "2288");
        List<String> patternData = Arrays.asList("88", "88");
        String match = Result.gridSearch(gridData, patternData);
        assertThat(match).isEqualTo("YES");
    }

    @Test
    public void gridSearch_PatternDoesNotMatch_FoundNo() {
        List<String> gridData = Arrays.asList("2112", "2112");
        List<String> patternData = Arrays.asList("11", "99");
        String match = Result.gridSearch(gridData, patternData);
        assertThat(match).isEqualTo("NO");
    }

    @Test
    public void gridSearch_HackerRankSampleInputMatches_FoundYes() {
        //@formatter:off
        List<String> gridData = Arrays.asList(
                "7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137"
        );
        List<String> patternData = Arrays.asList(
                "9505",
                "3845",
                "3530"
        );
        //@formatter:on
        String match = Result.gridSearch(gridData, patternData);
        assertThat(match).isEqualTo("YES");
    }
}
