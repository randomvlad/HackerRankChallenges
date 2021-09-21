package hackrank.algorithm.string.mkanagram;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Make it Anagram Challenge
 *
 * @see https://www.hackerrank.com/challenges/make-it-anagram
 */
public class Solution {

    public static void main(String[] args) {

        String[] values = readInput(System.in);
        System.out.println(countAnagramDeletes(values[0], values[1]));
    }

    public static int countAnagramDeletes(String value1, String value2) {

        int i = 0;
        int j = 0;
        int deletions = 0;
        char[] c1 = value1.toCharArray();
        char[] c2 = value2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        while (i < c1.length || j < c2.length) {

            if (i < c1.length && j < c2.length) {
                if (c1[i] == c2[j]) {
                    i++;
                    j++;
                } else if (c1[i] < c2[j]) {
                    i++;
                    deletions++;
                } else {
                    j++;
                    deletions++;
                }
            } else if (i < c1.length) {
                i++;
                deletions++;
            } else {
                j++;
                deletions++;
            }
        }

        return deletions;
    }

    public static String[] readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        String value1 = scanner.next();
        String value2 = scanner.next();

        scanner.close();

        return new String[] { value1, value2 };
    }

}
