package hackrank.algorithm.sort.insert2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.hackerrank.com/challenges/insertionsort2">Insertion Sort Part 2</a>
 */
public class Result {

    /**
     * Print the list of numbers as a row of space-separated integers at each sort iteration.
     *
     * @param n   size of list (parameter is not needed or used)
     * @param arr List of numbers
     */
    public static void insertionSort2(int n, List<Integer> arr) {
        List<String> steps = insertionSortSteps(arr);
        for (String step : steps) {
            System.out.println(step);
        }
    }

    public static List<String> insertionSortSteps(List<Integer> numbers) {
        List<String> steps = new ArrayList<>();
        for (int indexToSort = 1; indexToSort < numbers.size(); indexToSort++) {
            insertSortOneElement(numbers, indexToSort);

            String step = numbers.stream().map(String::valueOf).collect(Collectors.joining(" "));
            steps.add(step);
        }
        return steps;
    }

    private static void insertSortOneElement(List<Integer> numbers, int indexToSort) {
        int unsortedElement = numbers.get(indexToSort);

        // insert to 0th index if unsortedElement is less than all other elements
        int indexToInsert = 0;
        for (int i = indexToSort - 1; i >= 0; i--) {
            if (unsortedElement > numbers.get(i)) {
                indexToInsert = i + 1;
                break;
            } else {
                numbers.set(i + 1, numbers.get(i));
            }
        }

        numbers.set(indexToInsert, unsortedElement);
    }
}
