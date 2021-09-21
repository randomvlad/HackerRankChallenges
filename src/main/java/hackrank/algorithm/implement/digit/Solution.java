package hackrank.algorithm.implement.digit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find Digits Challenge
 *
 * @see https://www.hackerrank.com/challenges/find-digits
 */
public class Solution {

    public static void main(String[] args) {

        List<String> numbers = readInput();

        for (String number : numbers) {
            System.out.println(countExactDivisions(number));
        }
    }

    private static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        List<String> numbers = new ArrayList<>(testCases);
        for (int i = 0; i < testCases; i++) {
            numbers.add(scanner.next());
        }

        scanner.close();

        return numbers;
    }

    private static int countExactDivisions(String stringNumber) {
        int integer = Integer.valueOf(stringNumber);

        int count = 0;

        for (char character : stringNumber.toCharArray()) {
            int digit = Integer.valueOf(String.valueOf(character));

            if (digit != 0 && integer % digit == 0) {
                count++;
            }
        }

        return count;
    }

}
