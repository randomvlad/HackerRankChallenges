package hackrank.algorithm.string.two;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.hackerrank.com/challenges/two-strings">Two Strings</a>
 */
public class Result {

    /**
     * @param s1 first string value
     * @param s2 second string value
     * @return value "YES" if {@code s1} and {@code s2} share a common substring, else "NO".
     */
    public static String twoStrings(String s1, String s2) {
        Set<Character> uniqueCharsSecond = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        boolean containsSubstring = s1.chars().anyMatch(c -> uniqueCharsSecond.contains((char) c));
        return containsSubstring ? "YES" : "NO";
    }
}
