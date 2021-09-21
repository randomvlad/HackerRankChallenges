package hackrank.algorithm.sort.count1;

import java.util.Scanner;

/**
 * Counting Sort 1 Challenge
 *
 * @see https://www.hackerrank.com/challenges/countingsort1
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

        for (int count : counts) {
            System.out.print(count + " ");
        }
    }

}
