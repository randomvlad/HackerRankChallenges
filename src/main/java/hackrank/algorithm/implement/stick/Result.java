package hackrank.algorithm.implement.stick;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/cut-the-sticks">Cut the Sticks</a>
 */
public class Result {

    private static final int STICK_MAX_LENGTH = 1000;

    /**
     * @param arr List of stick lengths
     * @return List with number of sticks left after each iteration of cuts
     */
    public static List<Integer> cutTheSticks(List<Integer> arr) {

        // add an extra one to array size to keep things "nicer". First element at index 0 will
        // never be used because a stick can never start out with 0 length
        int[] lengthCounts = new int[STICK_MAX_LENGTH + 1];

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (Integer stickLength : arr) {
            if (stickLength < minLength) {
                minLength = stickLength;
            }

            if (stickLength > maxLength) {
                maxLength = stickLength;
            }

            lengthCounts[stickLength]++; // use stick length as array index and array value is the count
        }

        int sticksLeft = arr.size();
        List<Integer> cutIterations = new ArrayList<>();

        for (int i = minLength; i <= maxLength; i++) {
            if (lengthCounts[i] != 0) {
                cutIterations.add(sticksLeft);
                sticksLeft -= lengthCounts[i];
            }
        }

        return cutIterations;
    }
}
