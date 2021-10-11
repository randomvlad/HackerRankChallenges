package hackrank.algorithm.string.sherlock;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://www.hackerrank.com/challenges/sherlock-and-valid-string">Sherlock and the Valid String</a>
 */
public class Result {

    /**
     * @param s lowercase letters in ASCII range a-z
     * @return "YES" if {@code s} is a valid string, "NO"" otherwise.
     */
    public static String isValid(String s) {
        Map<Character, Integer> counts = countChars(s);

        boolean valid = false;
        if (hasEqualCounts(counts, '-')) {
            // use '-' dummy char to check if original value is already valid and requires no fixing
            valid = true;
        } else {
            // iterate over chars to see if decrementing their count by 1 equals out other counts
            for (char character : counts.keySet()) {
                if (hasEqualCounts(counts, character)) {
                    valid = true;
                    break;
                }
            }
        }

        return valid ? "YES" : "NO";
    }

    private static Map<Character, Integer> countChars(String value) {

        Map<Character, Integer> counts = new HashMap<>();
        for (char character : value.toCharArray()) {
            if (!counts.containsKey(character)) {
                counts.put(character, 0);
            }

            int count = counts.get(character);
            count++;
            counts.put(character, count);
        }

        return counts;
    }

    private static boolean hasEqualCounts(Map<Character, Integer> counts, char charToReduceByOne) {

        int firstCount = -1;

        for (char character : counts.keySet()) {
            int count = counts.get(character);
            if (character == charToReduceByOne) {
                count--;
            }

            if (count <= 0) {
                continue;
            }

            if (firstCount == -1) {
                firstCount = count;
                continue;
            }

            if (firstCount != count) {
                return false;
            }
        }

        return true;
    }
}
