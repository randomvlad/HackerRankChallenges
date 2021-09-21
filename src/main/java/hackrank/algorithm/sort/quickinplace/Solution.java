package hackrank.algorithm.sort.quickinplace;

import java.util.Scanner;

/**
 * Quicksort In-Place Challenge
 *
 * @see https://www.hackerrank.com/challenges/quicksort3
 */
public class Solution {

    public static void main(String[] args) {
        sort(readInput());
    }

    private static void sort(int[] array) {
        sort(array, 0, array.length);
    }

    private static void sort(int[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int pivotIndex = partition(array, start, end);
        sort(array, start, pivotIndex);
        sort(array, pivotIndex + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end - 1];

        int indexLeftSide = start;
        for (int i = start; i < end - 1; i++) {
            int number = array[i];

            if (number < pivot) {
                array[i] = array[indexLeftSide];
                array[indexLeftSide] = number;
                indexLeftSide++;
            }
        }

        int pivotIndex = indexLeftSide;
        array[end - 1] = array[pivotIndex];
        array[pivotIndex] = pivot;

        System.out.println(toString(array));

        return pivotIndex;
    }

    private static int[] readInput() {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        return array;
    }

    private static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }

}
