package hackrank.algorithm.implement.utopian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utopian Tree Challenge
 *
 * @see https://www.hackerrank.com/challenges/utopian-tree
 */
public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>(testCases);
        for (int i = 0; i < testCases; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        for (Integer numberCycles : numbers) {
            System.out.println(findUtopianTreeHeight(1, numberCycles));
        }
    }

    private static int findUtopianTreeHeight(int height, int numberCycles) {
        if (numberCycles == 0) {
            return height;
        } else if (numberCycles == 1) {
            return height * 2;
        } else if (numberCycles == 2) {
            return height * 2 + 1;
        } else {
            return findUtopianTreeHeight(height * 2 + 1, numberCycles - 2);
        }
    }

}
