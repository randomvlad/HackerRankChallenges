package hackrank.algorithm.greedy.maxmin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Max Min Challenge
 *
 * @see https://www.hackerrank.com/challenges/angry-children
 */
public class Solution {

    public static void main(String[] args) {

        Data data = readInput(System.in);
        System.out.println(data.findUnfairMin());
    }

    public static Data readInput(InputStream stream) {
        Scanner scanner = new Scanner(stream);

        int size = scanner.nextInt();
        int select = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        return new Data(numbers, select);
    }

}

class Data {

    List<Integer> numbers;
    int select;

    Data(List<Integer> numbers, int select) {
        this.numbers = numbers;
        this.select = select;
    }

    public int findUnfairMin() {

        Collections.sort(numbers);

        int i = 0;
        int j = select - 1;

        int smallestDiff = Integer.MAX_VALUE;

        while (j < numbers.size()) {
            int min = numbers.get(i);
            int max = numbers.get(j);
            int diff = max - min;

            if (diff < smallestDiff) {
                smallestDiff = diff;
            }

            i++;
            j++;
        }

        return smallestDiff;
    }

}
