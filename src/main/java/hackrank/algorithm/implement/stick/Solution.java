package hackrank.algorithm.implement.stick;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cut the Sticks Challenge
 *
 * @see https://www.hackerrank.com/challenges/cut-the-sticks
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> numbers = readInput();

        int size = numbers.size();
        while (size > 0) {
            System.out.println(size);
            reduce(numbers);
            size = numbers.size();
        }
    }

    private static void reduce(List<Integer> numbers) {

        int min = numbers.stream().min(Integer::compareTo).get();

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            numbers.set(i, number - min);
        }

        numbers.removeIf(i -> i <= 0);
    }

    private static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);

        int numberElements = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>(numberElements);
        for (int i = 0; i < numberElements; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        return numbers;
    }

}
