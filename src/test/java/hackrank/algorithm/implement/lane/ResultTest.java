package hackrank.algorithm.implement.lane;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void serviceLane_IncreasingWidth_ExpectedMaxVehicleWidths() {
        List<Integer> serviceLaneWidths = Arrays.asList(1, 2, 3, 3);
        List<List<Integer>> cases = toListPairs("0:1", "1:1", "1:2", "2:3", "0:3");

        List<Integer> maxVehicleWidths = Result.serviceLane(serviceLaneWidths.size(), serviceLaneWidths, cases);
        assertThat(maxVehicleWidths).hasSize(5).containsExactly(1, 2, 2, 3, 1);
    }

    @Test
    public void serviceLane_HackerRankExample_ExpectedMaxVehicleWidths() {
        List<Integer> serviceLaneWidths = Arrays.asList(2, 3, 1, 2, 3, 2, 3, 3);
        List<List<Integer>> cases = toListPairs("0:3", "4:6", "6:7", "3:5", "0:7");

        List<Integer> maxVehicleWidths = Result.serviceLane(serviceLaneWidths.size(), serviceLaneWidths, cases);
        assertThat(maxVehicleWidths).hasSize(5).containsExactly(1, 2, 3, 2, 1);
    }

    /**
     * Helper method to create a list of integer pair tuples.
     */
    private List<List<Integer>> toListPairs(String... segments) {
        return Arrays.stream(segments).map(segment -> {
            String[] startEnd = segment.split(":");
            int start = Integer.parseInt(startEnd[0]);
            int end = Integer.parseInt(startEnd[1]);
            return Arrays.asList(start, end);
        }).collect(Collectors.toList());
    }
}
