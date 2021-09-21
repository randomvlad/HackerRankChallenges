package hackrank.algorithm.dynamic.maxsub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Maximum Subarray Challenge
 *
 * @see https://www.hackerrank.com/challenges/maxsubarray
 */
public class Solution {

    public static void main(String[] args) {

        for (List<Integer> sequence : readInput()) {
            System.out.println(findMaxSumContiguous(sequence) + " " + findMaxSumNonContigious(sequence));
        }
    }

    public static int findMaxSumContiguous(List<Integer> sequence) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < sequence.size(); i++) {
            int value = sequence.get(i);

            currentSum += value;

            if (currentSum >= bestSum) {
                bestSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return bestSum;
    }

    public static int findMaxSumNonContigious(List<Integer> sequence) {

        int minNegative = Integer.MIN_VALUE;
        int sum = 0;

        for (int value : sequence) {
            if (value > 0) {
                sum += value;
            } else {
                if (value > minNegative) {
                    minNegative = value;
                }
            }
        }

        return sum > 0 ? sum : minNegative;
    }

    public static List<List<Integer>> readInput() {

        List<List<Integer>> sequences = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {

            int length = scanner.nextInt();
            List<Integer> sequence = new ArrayList<>(length);

            for (int j = 0; j < length; j++) {
                sequence.add(scanner.nextInt());
            }

            sequences.add(sequence);
        }

        scanner.close();

        return sequences;
    }

}
