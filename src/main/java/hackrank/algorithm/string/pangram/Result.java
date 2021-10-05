package hackrank.algorithm.string.pangram;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.hackerrank.com/challenges/pangrams">Pangrams</a>
 */
public class Result {

    public final static int ALPHABET_ENGLISH_SIZE = 26;

    /**
     * @param s value to check
     * @return String value "pangram" or "not pangram"
     */
    public static String pangrams(String s) {
        return isPangram(s) ? "pangram" : "not pangram";
    }

    private static boolean isPangram(String text) {
        text = text.toLowerCase().replaceAll("[^a-z]", "");

        if (text.length() < ALPHABET_ENGLISH_SIZE) {
            return false;
        }

        Set<Character> uniqueLetters = text.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return uniqueLetters.size() == ALPHABET_ENGLISH_SIZE;
    }
}
