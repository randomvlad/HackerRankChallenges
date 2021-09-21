package hackrank.algorithm.bit.sansa;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sansa and XOR Challenge
 *
 * @see https://www.hackerrank.com/challenges/sansa-and-xor
 */
public class Solution {

    public static void main(String[] args) {
        for (Integer[] numbers : readInput(System.in)) {
            System.out.println(contiguousXorAll(numbers));
        }
    }

    private static int contiguousXorAll(Integer[] numbers) {

        if (numbers.length % 2 == 0) {
            return 0;
        } else {
            int total = 0;
            for (int i = 0; i < numbers.length; i += 2) {
                total ^= numbers[i];
            }
            return total;
        }
    }

    public static List<Integer[]> readInput(InputStream input) {

        Scanner scanner = new Scanner(input);

        int testCases = scanner.nextInt();
        List<Integer[]> data = new ArrayList<>(testCases);

        for (int i = 0; i < testCases; i++) {

            int length = scanner.nextInt();
            Integer[] numbers = new Integer[length];

            for (int j = 0; j < length; j++) {
                numbers[j] = scanner.nextInt();
            }

            data.add(numbers);
        }

        scanner.close();

        return data;
    }

}
