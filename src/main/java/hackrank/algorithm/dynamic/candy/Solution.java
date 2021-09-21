package hackrank.algorithm.dynamic.candy;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Candies Challenge
 *
 * @see https://www.hackerrank.com/challenges/candies
 */
public class Solution {

    public static void main(String[] args) {

        int[] performances = readInput(System.in);
        System.out.println(countCandies(performances));
    }

    public static int countCandies(int[] performances) {
        if (performances.length == 1) {
            return 1;
        }

        int[] candies = new int[performances.length];
        candies[0] = 1;

        for (int i = 1; i < performances.length; i++) {
            int prev = performances[i - 1];
            int current = performances[i];

            if (current > prev) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        // traverse performances and candies in reverse; fix discrepancies in rewards
        for (int i = performances.length - 1; i > 0; i--) {
            int prev = performances[i];
            int current = performances[i - 1];
            int prevCandy = candies[i];
            int currentCandy = candies[i - 1];

            if (current > prev && currentCandy <= prevCandy) {
                candies[i - 1] = prevCandy + 1;
            }
        }

        return Arrays.stream(candies).sum();
    }

    public static int[] readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        int size = scanner.nextInt();
        int[] performances = new int[size];
        for (int i = 0; i < size; i++) {
            performances[i] = scanner.nextInt();
        }

        scanner.close();

        return performances;
    }

}
