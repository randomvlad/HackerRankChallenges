package hackrank.algorithm.sort.insert2;

import java.util.Scanner;

/**
 * Insertion Sort Part 2
 *
 * @see https://www.hackerrank.com/challenges/insertionsort2
 */
public class Solution {

    public static void main(String[] args) {

        int[] unsorted = readInputArray();

        for (int i = 2; i <= unsorted.length; i++) {
            insertSort(unsorted, i);
            printArray(unsorted);
        }
    }

    private static void insertSort(int[] almostSorted, int length) {
        int unsortedElement = almostSorted[length - 1];

        // insert to 0th index if unsortedElement is less than all other elements
        int indexToInsert = 0;
        for (int i = length - 2; i >= 0; i--) {
            if (unsortedElement > almostSorted[i]) {
                indexToInsert = i + 1;
                break;
            } else {
                almostSorted[i + 1] = almostSorted[i];
            }
        }

        almostSorted[indexToInsert] = unsortedElement;
    }

    private static int[] readInputArray() {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] unsorted = new int[length];
        for (int i = 0; i < length; i++) {
            unsorted[i] = scanner.nextInt();
        }

        scanner.close();

        return unsorted;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
    }

}
