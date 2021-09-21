package hackrank.algorithm.string.anagram;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Anagram Challenge
 *
 * @see https://www.hackerrank.com/challenges/anagram
 */
public class Solution {

    public static void main(String[] args) {

        for (String value : readInput(System.in)) {
            System.out.println(countChangesToAnagram(value));
        }

    }

    public static int countChangesToAnagram(String value) {
        if (value.length() % 2 == 1) {
            return -1;
        }

        int middle = value.length() / 2;
        char[] first = value.substring(0, middle).toCharArray();
        char[] second = value.substring(middle, value.length()).toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);

        int changes = 0;
        int freebiesFirst = 0;
        int freebiesSecond = 0;
        int i = 0;
        int j = 0;
        while (i < first.length) {

            if (first[i] == second[j]) {
                i++;
                j++;
                continue;
            }

            if (first[i] < second[j]) {
                i++;

                if (freebiesFirst > 0) {
                    freebiesFirst--;
                } else {
                    changes++;
                    freebiesSecond++;
                }

            } else {
                j++;

                if (freebiesSecond > 0) {
                    freebiesSecond--;
                } else {
                    changes++;
                    freebiesFirst++;
                }
            }
        }

        return changes;
    }

    public static List<String> readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        int size = scanner.nextInt();
        List<String> values = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            values.add(scanner.next());
        }

        scanner.close();

        return values;
    }

}
