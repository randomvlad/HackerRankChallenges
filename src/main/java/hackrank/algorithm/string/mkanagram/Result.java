package hackrank.algorithm.string.mkanagram;

import java.util.Arrays;

/**
 * @see <a href="https://www.hackerrank.com/challenges/making-anagrams">Making Anagrams</a>
 */
public class Result {

    /**
     * @param s1 first string value
     * @param s2 second string value
     * @return Minimum number of deletions needed from {@code s1} and/or {@code s2} to make an anagram
     */
    public static int makingAnagrams(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);

        int i = 0;
        int j = 0;
        int deletions = 0;
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
}
