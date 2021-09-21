package hackrank.algorithm.implement.squares;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sherlock and Squares Challenge
 *
 * @see https://www.hackerrank.com/challenges/sherlock-and-squares
 */
public class Solution {

    public static void main(String[] args) {

        for (Integer[] range : readInput(System.in)) {
            int start = range[0];
            int end = range[1];

            System.out.println(countSquares(start, end));
        }
    }

    public static int countSquares(int start, int end) {

        int sqStart = (int) Math.ceil(Math.sqrt(start));
        int sqEnd = (int) Math.floor(Math.sqrt(end));

        return sqStart <= sqEnd ? (sqEnd - sqStart + 1) : 0;
    }

    public static List<Integer[]> readInput(InputStream input) {

        Scanner scanner = new Scanner(input);

        int numberTests = scanner.nextInt();
        List<Integer[]> ranges = new ArrayList<>(numberTests);

        for (int i = 0; i < numberTests; i++) {
            ranges.add(new Integer[] { scanner.nextInt(), scanner.nextInt() });
        }

        scanner.close();

        return ranges;
    }

}
