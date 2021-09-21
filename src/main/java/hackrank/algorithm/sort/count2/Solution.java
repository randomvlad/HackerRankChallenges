package hackrank.algorithm.sort.count2;

import java.util.Scanner;

/**
 * Counting Sort Part 2 Challenge
 *
 * @see https://www.hackerrank.com/challenges/countingsort2
 */
public class Solution {

    public static void main(String[] args) {

        int[] counts = new int[100];

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            int number = scanner.nextInt();
            counts[number]++;
        }

        scanner.close();

        for (int number = 0; number < counts.length; number++) {
            if (counts[number] > 0) {
                System.out.print(repeat(number, counts[number]));
            }
        }
    }

    private static String repeat(int value, int times) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++) {
            sb.append(value + " ");
        }

        return sb.toString();
    }

}
