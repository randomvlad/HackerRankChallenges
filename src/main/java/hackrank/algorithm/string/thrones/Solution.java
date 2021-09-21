package hackrank.algorithm.string.thrones;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Game of Thrones Challenge
 *
 * @see https://www.hackerrank.com/challenges/game-of-thrones
 */
public class Solution {

    public static void main(String[] args) {
        String value = readInput(System.in);
        System.out.println(hasPalindromePermute(value) ? "YES" : "NO");
    }

    public static boolean hasPalindromePermute(String value) {

        Map<Character, Integer> occurences = new HashMap<>();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);

            if (occurences.containsKey(c)) {
                int count = occurences.get(c);
                occurences.put(c, count + 1);
            } else {
                occurences.put(c, 1);
            }
        }

        boolean singleOddCount = false;

        for (char c : occurences.keySet()) {
            int count = occurences.get(c);

            if (count % 2 == 0) {
                continue;
            }

            if (singleOddCount) {
                return false;
            } else {
                singleOddCount = true;
            }
        }

        return true;
    }

    public static String readInput(InputStream input) {

        Scanner scanner = new Scanner(input);
        String line = scanner.next();
        scanner.close();

        return line;
    }

}
