package hackrank.algorithm.sort.insert1;

import java.util.Scanner;

/**
 * Insertion Sort - Part 1
 *
 * @see https://www.hackerrank.com/challenges/insertionsort1
 */
public class Solution {

    public static void main(String[] args) {

        int[] almostSorted = readInputArray();
        int unsortedElement = almostSorted[almostSorted.length - 1];

        // insert to 0th index if unsortedElement is less than all other elements
        int indexToInsert = 0;
        for (int i = almostSorted.length - 2; i >= 0; i--) {
            if (unsortedElement > almostSorted[i]) {
                indexToInsert = i + 1;
                break;
            } else {
                almostSorted[i + 1] = almostSorted[i];
                printArray(almostSorted);
            }
        }

        almostSorted[indexToInsert] = unsortedElement;
        printArray(almostSorted);
    }

    private static int[] readInputArray() {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] almostSorted = new int[length];
        for (int i = 0; i < length; i++) {
            almostSorted[i] = scanner.nextInt();
        }

        scanner.close();

        return almostSorted;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
    }

}
