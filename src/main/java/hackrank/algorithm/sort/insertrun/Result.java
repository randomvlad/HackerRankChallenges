package hackrank.algorithm.sort.insertrun;

import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/runningtime">Insert Sort Running Time of Algorithms</a>
 */
public class Result {

    /**
     * @param arr List of numbers to analyze for runtime complexity
     * @return Number of insert sort shifts needed
     */
    public static int runningTime(List<Integer> arr) {
        int numberShifts = 0;

        for (int sortIndex = 1; sortIndex < arr.size(); sortIndex++) {
            int sortValue = arr.get(sortIndex);
            int j = sortIndex - 1;
            while (j >= 0 && arr.get(j) > sortValue) {
                arr.set(j + 1, arr.get(j)); // shift to the left
                j--;
                numberShifts++;
            }
            arr.set(j + 1, sortValue);
        }

        return numberShifts;
    }
}
