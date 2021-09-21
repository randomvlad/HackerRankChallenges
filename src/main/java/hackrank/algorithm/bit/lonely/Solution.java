package hackrank.algorithm.bit.lonely;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Lonely Integer Challenge
 *
 * @see https://www.hackerrank.com/challenges/lonely-integer
 */
public class Solution {

    public static void main(String[] args) {

        int lonely = 0;
        for (int number : readInput(System.in)) {
            lonely ^= number;
        }

        System.out.println(lonely);
    }

    public static int[] readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        int length = scanner.nextInt();
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        scanner.close();

        return numbers;
    }

}
