package hackrank.algorithm.string.funny;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Funny String Challenge
 *
 * @see https://www.hackerrank.com/challenges/funny-string
 */
public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        List<Boolean> funnies = new ArrayList<>(testCases);
        for (int i = 0; i < testCases; i++) {
            funnies.add(isFunny(scanner.next()));
        }

        scanner.close();

        for (boolean funny : funnies) {
            System.out.println(funny ? "Funny" : "Not Funny");
        }
    }

    private static boolean isFunny(String value) {
        if (value.length() < 2) {
            return false;
        }

        char[] reverse = new StringBuilder(value).reverse().toString().toCharArray();
        char[] characters = value.toCharArray();

        for (int i = 1; i < characters.length; i++) {
            if (Math.abs(characters[i] - characters[i - 1]) != Math.abs(reverse[i] - reverse[i - 1])) {
                return false;
            }
        }

        return true;
    }

}
