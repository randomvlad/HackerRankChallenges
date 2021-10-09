package hackrank.algorithm.string.anagram;

import java.util.Arrays;

/**
 * @see <a href="https://www.hackerrank.com/challenges/anagram">Anagram</a>
 */
public class Result {

    /**
     * @param s value to check for anagram
     * @return minimum number of characters to change {@code s} to an anagram. -1 if not possible.
     */
    public static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }

        int middle = s.length() / 2;
        char[] first = s.substring(0, middle).toCharArray();
        char[] second = s.substring(middle).toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);

        int changes = 0;
        int freebiesFirst = 0;
        int freebiesSecond = 0;
        int i = 0;
        int j = 0;
        while (i < first.length && j < second.length) {

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
}
