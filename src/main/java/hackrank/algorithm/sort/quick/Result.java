package hackrank.algorithm.sort.quick;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a href="https://www.hackerrank.com/challenges/quicksort2">Quicksort 2 - Sorting</a>
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
     * @param array Numbers to sort
     * @return List of every partitioned sub-array produced during sort.
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

        int pivotIndex = partitionAroundPivot(array, start, end);

        sort(array, start, pivotIndex, steps);
        sort(array, pivotIndex + 1, end, steps);

        steps.add(toString(array, start, end));
    }

    private static int partitionAroundPivot(int[] array, int start, int end) {
        int pivot = array[start];

        int maxSize = end - start - 1;
        List<Integer> leftPartition = new ArrayList<>(maxSize);
        List<Integer> rightPartition = new ArrayList<>(maxSize);

        for (int i = start + 1; i < end; i++) {
            int number = array[i];

            if (number < pivot) {
                leftPartition.add(number);
            } else {
                rightPartition.add(number);
            }
        }

        return update(array, start, leftPartition, pivot, rightPartition);
    }

    private static int update(int[] array, int start, List<Integer> leftPartition, int pivot,
            List<Integer> rightPartition) {
        int index = start;

        for (int number : leftPartition) {
            array[index] = number;
            index++;
        }

        int pivotIndex = index;
        array[index] = pivot;
        index++;

        for (int number : rightPartition) {
            array[index] = number;
            index++;
        }

        return pivotIndex;
    }

    private static String toString(int[] array, int start, int end) {
        return IntStream.range(start, end).mapToObj(i -> String.valueOf(array[i])).collect(Collectors.joining(" "));
    }
}
