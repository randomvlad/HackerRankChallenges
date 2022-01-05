package hackrank.algorithm.sort.quickinplace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.hackerrank.com/challenges/quicksort3">Quicksort In-Place</a>
 */
public class Result {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        List<String> steps = sort(array);

        for (String step : steps) {
            System.out.println(step);
        }
    }

    /**
     * @param array Array to quicksort
     * @return List of states after each partition sort step.
     */
    public static List<String> sort(int[] array) {
        List<String> steps = new ArrayList<>();
        sort(array, 0, array.length, steps);
        return steps;
    }

    private static void sort(int[] array, int start, int end, List<String> steps) {
        if (end - start <= 1) {
            return;
        }

        int pivotIndex = partition(array, start, end);

        steps.add(toString(array));

        sort(array, start, pivotIndex, steps);
        sort(array, pivotIndex + 1, end, steps);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end - 1];

        int indexLeftSide = start;
        for (int i = start; i < end - 1; i++) {
            int number = array[i];

            if (number < pivot) {
                array[i] = array[indexLeftSide];
                array[indexLeftSide] = number;
                indexLeftSide++;
            }
        }

        int pivotIndex = indexLeftSide;
        array[end - 1] = array[pivotIndex];
        array[pivotIndex] = pivot;

        return pivotIndex;
    }

    private static String toString(int[] array) {
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
