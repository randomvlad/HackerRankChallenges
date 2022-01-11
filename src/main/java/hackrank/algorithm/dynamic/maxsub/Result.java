package hackrank.algorithm.dynamic.maxsub;

import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/maxsubarray">The Maximum Subarray</a>
 */
public class Result {

    /**
     * @param arr List of integers; Constraint: list size = 1 to 100,000
     * @return List with two integers: the maximum subarray and subsequence sums
     */
    public static List<Integer> maxSubarray(List<Integer> arr) {
        return Arrays.asList(findMaxSumContiguous(arr), findMaxSumNonContiguous(arr));
    }

    private static int findMaxSumContiguous(List<Integer> sequence) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int value : sequence) {
            currentSum += value;

            if (currentSum >= bestSum) {
                bestSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return bestSum;
    }

    private static int findMaxSumNonContiguous(List<Integer> sequence) {
        int minNegative = Integer.MIN_VALUE;
        int sum = 0;

        for (int value : sequence) {
            if (value > 0) {
                sum += value;
            } else if (value > minNegative) {
                minNegative = value;
            }
        }

        return sum > 0 ? sum : minNegative;
    }
}
