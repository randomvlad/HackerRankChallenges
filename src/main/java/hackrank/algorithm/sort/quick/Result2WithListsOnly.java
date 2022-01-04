package hackrank.algorithm.sort.quick;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Variation of the solution that uses only Lists. It results in a much cleaner and easier-to-follow implementation,
 * albeit more wasteful by needing more intermediate lists.
 *
 * @see <a href="https://www.hackerrank.com/challenges/quicksort2">Quicksort 2 - Sorting</a>
 */
public class Result2WithListsOnly {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(scanner.nextInt());
        }

        scanner.close();

        sort(list);
    }

    private static List<Integer> sort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }

        int pivot = list.get(0);

        int maxSize = list.size() - 1;
        List<Integer> leftPartition = new ArrayList<>(maxSize);
        List<Integer> rightPartition = new ArrayList<>(maxSize);

        for (int i = 1; i < list.size(); i++) {
            int number = list.get(i);

            if (number < pivot) {
                leftPartition.add(number);
            } else {
                rightPartition.add(number);
            }
        }

        leftPartition = sort(leftPartition);
        rightPartition = sort(rightPartition);

        List<Integer> combined = new ArrayList<>(list.size());

        combined.addAll(leftPartition);
        combined.add(pivot);
        combined.addAll(rightPartition);

        System.out.println(combined.stream().map(Object::toString).collect(Collectors.joining(" ")));

        return combined;
    }
}
