package hackrank.algorithm.search.icecream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ice Cream Parlor
 *
 * @see https://www.hackerrank.com/challenges/icecream-parlor
 */
public class Solution {

    public static void main(String[] args) {

        for (IceCreamParlor parlor : readInput(System.in)) {

            int[] priceIndices = pickTwoFlavors(parlor);
            int first = priceIndices[0] + 1;
            int second = priceIndices[1] + 1;

            System.out.println(first + " " + second);
        }
    }

    public static List<IceCreamParlor> readInput(InputStream input) {

        Scanner scanner = new Scanner(input);

        int testCases = scanner.nextInt();
        List<IceCreamParlor> parlors = new ArrayList<>(testCases);

        for (int t = 0; t < testCases; t++) {

            IceCreamParlor parlor = new IceCreamParlor();
            parlor.money = scanner.nextInt();

            int numberFlavors = scanner.nextInt();
            parlor.prices = new int[numberFlavors];
            for (int p = 0; p < numberFlavors; p++) {
                parlor.prices[p] = scanner.nextInt();
            }

            parlors.add(parlor);
        }

        scanner.close();

        return parlors;
    }

    public static int[] pickTwoFlavors(IceCreamParlor parlor) {

        for (int i = 0; i < parlor.prices.length - 1; i++) {
            for (int j = i + 1; j < parlor.prices.length; j++) {
                if (parlor.prices[i] + parlor.prices[j] == parlor.money) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }
}

class IceCreamParlor {

    int money;
    int[] prices;

}
