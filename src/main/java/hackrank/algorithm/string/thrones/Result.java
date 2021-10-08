package hackrank.algorithm.string.thrones;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://www.hackerrank.com/challenges/game-of-thrones">Game of Thrones</a>
 */
public class Result {

    /**
     * @param s value (lowercase ASCII letters only) to check for a palindromic permutation
     * @return "YES" if there is a palindromic permutation of {@code s}, else "NO".
     */
    public static String gameOfThrones(String s) {
        Map<Character, Integer> counts = countChars(s);

        int charsOddCount = 0;
        for (int count : counts.values()) {
            if (count % 2 == 0) {
                continue; // char has an even count and can be evenly split between each side of palindrome
            }

            charsOddCount++;
            if (charsOddCount > 1) {
                // at least two characters with odd counts. distribution is uneven and a palindrome is not possible
                return "NO";
            }
        }

        return "YES";
    }

    private static Map<Character, Integer> countChars(String value) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : value.toCharArray()) {
            if (counts.containsKey(c)) {
                int count = counts.get(c);
                counts.put(c, count + 1);
            } else {
                counts.put(c, 1);
            }
        }
        return counts;
    }
}
