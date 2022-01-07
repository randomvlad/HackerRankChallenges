package hackrank.algorithm.sort.count1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.hackerrank.com/challenges/countingsort1">Counting Sort 1</a>
 */
public class Result {

    public static List<Integer> countingSort(List<Integer> arr) {
        int[] counts = new int[100];

        for (int number : arr) {
            counts[number]++;
        }

        return Arrays.stream(counts).boxed().collect(Collectors.toList());
    }
}
