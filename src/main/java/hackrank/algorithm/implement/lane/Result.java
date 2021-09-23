package hackrank.algorithm.implement.lane;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * DISCLAIMER: HackerRank code console generates an incomplete method signature to solve the problem (this was the case
 * on Sep 23, 2021). To fix generated code, add {@code width} parameter to {@code serviceLane()} method AND update logic
 * in {@code Solution.main()} to pass it in.
 * </p>
 *
 * @see <a href="https://www.hackerrank.com/challenges/service-lane">Service Lane</a>
 */
public class Result {

    /**
     * @param length length of service lane and number of points within
     * @param width  width value for each service lane point
     * @param cases  tuples of start (inclusive) and end (inclusive) indices for a segment to consider
     * @return List of maximum width vehicle (1, 2 or 3) that can pass through for each provided {@code cases}
     */
    public static List<Integer> serviceLane(int length, List<Integer> width, List<List<Integer>> cases) {

        List<Integer> maxVehicleWidths = new ArrayList<>(cases.size());

        for (List<Integer> startEnd : cases) {
            int start = startEnd.get(0);
            int end = startEnd.get(1);

            int minWidth = width.subList(start, end + 1).stream().min(Integer::compareTo).get();

            maxVehicleWidths.add(minWidth);
        }

        return maxVehicleWidths;
    }
}
