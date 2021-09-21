package hackrank.algorithm.greedy.arrays;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Two Arrays Challenge
 *
 * @see https://www.hackerrank.com/challenges/two-arrays
 */
public class Solution {

    public static void main(String[] args) {

        for (Data data : readInput(System.in)) {
            System.out.println(hasPermutation(data) ? "YES" : "NO");
        }
    }

    public static boolean hasPermutation(Data data) {

        Collections.sort(data.numbersOne);
        Collections.sort(data.numbersTwo, Collections.reverseOrder());

        for (int i = 0; i < data.numbersOne.size(); i++) {
            if (data.numbersOne.get(i) + data.numbersTwo.get(i) < data.target) {
                return false;
            }
        }

        return true;
    }

    public static List<Data> readInput(InputStream input) {

        Scanner scanner = new Scanner(input);

        int numberTests = scanner.nextInt();
        List<Data> list = new ArrayList<>(numberTests);

        for (int t = 0; t < numberTests; t++) {

            int length = scanner.nextInt();
            int target = scanner.nextInt();

            List<Integer> numbersOne = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                numbersOne.add(scanner.nextInt());
            }

            List<Integer> numbersTwo = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                numbersTwo.add(scanner.nextInt());
            }

            list.add(new Data(target, numbersOne, numbersTwo));
        }

        scanner.close();

        return list;
    }

}

class Data {

    int target;
    List<Integer> numbersOne;
    List<Integer> numbersTwo;

    Data(int target, List<Integer> numbersOne, List<Integer> numbersTwo) {
        this.target = target;
        this.numbersOne = numbersOne;
        this.numbersTwo = numbersTwo;
    }

}
