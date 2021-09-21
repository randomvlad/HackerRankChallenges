package hackrank.algorithm.string.alternate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Alternating Characters
 *
 * @see https://www.hackerrank.com/challenges/alternating-characters
 */
public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        List<Integer> deleteCounts = new ArrayList<>(testCases);
        for (int i = 0; i < testCases; i++) {
            char[] characters = scanner.next().toCharArray();
            deleteCounts.add(findMinDeletions(characters));
        }

        scanner.close();

        for (int deleteCount : deleteCounts) {
            System.out.println(deleteCount);
        }
    }

    private static int findMinDeletions(char[] characters) {
        int deletions = 0;

        for (int i = 1; i < characters.length; i++) {
            char previous = characters[i - 1];
            char current = characters[i];

            if (previous == current) {
                deletions++;
            }
        }

        return deletions;
    }

}
