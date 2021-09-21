package hackrank.algorithm.bit.maxxor;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Maximizing XOR Challenge
 *
 * @see https://www.hackerrank.com/challenges/maximizing-xor
 */
public class Solution {

    public static void main(String[] args) {

        int[] range = readInput(System.in);
        int start = range[0];
        int end = range[1];

        int bestMax = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                int max = i ^ j;

                // System.out.println( i + " XOR " + j + " = " + max );

                if (max > bestMax) {
                    bestMax = max;
                }
            }
        }

        System.out.println(bestMax);
    }

    public static int[] readInput(InputStream input) {

        Scanner scanner = new Scanner(input);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.close();

        return new int[] { start, end };
    }

}
