package hackrank.algorithm.sort.count2;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/countingsort2">Counting Sort Part 2</a>
 */
public class Result {

    /**
     * @param arr Unsorted list of numbers; Numbers range: 0 to 99 (inclusive)
     * @return Sorted list based on counting sort algorithm
     */
    public static List<Integer> countingSort(List<Integer> arr) {

        int[] counts = new int[100];
        for (int number : arr) {
            counts[number]++;
        }

        List<Integer> sorted = new ArrayList<>();

        for (int number = 0; number < counts.length; number++) {
            int count = counts[number];
            if (count > 0) {
                for (int c = 0; c < count; c++) {
                    sorted.add(number);
                }
            }
        }

        return sorted;
    }
}
