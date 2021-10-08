package hackrank.algorithm.string.shergram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a href="https://www.hackerrank.com/challenges/sherlock-and-anagrams">Sherlock and Anagrams</a>
 */
public class Result {

    /**
     * @param s value to look for substrings of anagrammatic pairs
     * @return number of unordered anagrammatic pairs of substrings in {@code s}
     */
    public static int sherlockAndAnagrams(String s) {
        int count = 0;
        for (int substringLength = 1; substringLength < s.length(); substringLength++) {
            List<String> substrings = findSubstrings(s, substringLength);

            for (int i = 0; i < substrings.size(); i++) {
                for (int j = i + 1; j < substrings.size(); j++) {
                    if (substrings.get(i).equals(substrings.get(j))) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static List<String> findSubstrings(String value, int length) {
        int numberSubstrings = value.length() - length + 1;

        return IntStream.range(0, numberSubstrings).mapToObj(i -> {
            char[] charsSubstring = getSubstring(value, i, length);
            Arrays.sort(charsSubstring); // sort to "normalize" anagrams. allows for a simple string equals comparison
            return new String(charsSubstring);
        }).collect(Collectors.toList());
    }

    private static char[] getSubstring(String value, int startIndex, int length) {
        char[] substring = new char[length];
        for (int i = startIndex, j = 0; i < startIndex + length; i++, j++) {
            substring[j] = value.charAt(i);
        }
        return substring;
    }
}
