package hackrank.algorithm.string.child;

import java.util.Scanner;

/**
 * Common Child Challenge
 *
 * @see https://www.hackerrank.com/challenges/common-child
 */
public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();

        System.out.println(findMaxCommonLength(a, b));
    }

    public static int findMaxCommonLength(String a, String b) {

        int[][] matrix = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {

                int value = 0;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    value = matrix[i - 1][j - 1] + 1;
                } else {
                    value = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }

                matrix[i][j] = value;
            }
        }

        return matrix[a.length()][b.length()];
    }

}
