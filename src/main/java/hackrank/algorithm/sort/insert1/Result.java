package hackrank.algorithm.sort.insert1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.hackerrank.com/challenges/insertionsort1">Insertion Sort - Part 1</a>
 */
public class Result {

    /**
     * Print the array as a row of space-separated integers each time there is a shift or insertion.
     *
     * @param n   size of list (parameter is not needed or used)
     * @param arr List of numbers
     */
    public static void insertionSort1(int n, List<Integer> arr) {
        List<String> steps = insertionSortSteps(arr);
        for (String step : steps) {
            System.out.println(step);
        }
    }

    public static List<String> insertionSortSteps(List<Integer> numbers) {
        List<String> steps = new ArrayList<>();

        int lastNumber = numbers.get(numbers.size() - 1);

        // insert to 0th index if lastNumber is less than all other elements
        int indexToInsert = 0;
        for (int index = numbers.size() - 2; index >= 0; index--) {
            if (lastNumber > numbers.get(index)) {
                indexToInsert = index + 1;
                break;
            } else {
                numbers.set(index + 1, numbers.get(index));

                steps.add(toString(numbers));
            }
        }

        numbers.set(indexToInsert, lastNumber);

        steps.add(toString(numbers));

        return steps;
    }

    private static String toString(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
