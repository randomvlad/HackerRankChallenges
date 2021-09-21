package hackrank.algorithm.greedy.flowers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Flowers Challenge
 *
 * @see https://www.hackerrank.com/challenges/flowers
 */
public class Solution {

    public static void main(String[] args) {

        FlowerShop flowerShop = readInput(System.in);
        System.out.println(calculateTotalPurchase(flowerShop));
    }

    public static int calculateTotalPurchase(FlowerShop shop) {

        Collections.sort(shop.prices, Collections.reverseOrder());

        int total = 0;
        int multiplier = 0;
        int personIndex = 0;
        for (int price : shop.prices) {
            total += (multiplier + 1) * price;
            personIndex++;
            if (personIndex == shop.people) {
                personIndex = 0;
                multiplier++;
            }
        }

        return total;
    }

    public static FlowerShop readInput(InputStream stream) {
        Scanner scanner = new Scanner(stream);

        int size = scanner.nextInt();
        int people = scanner.nextInt();

        List<Integer> prices = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            prices.add(scanner.nextInt());
        }

        scanner.close();

        return new FlowerShop(people, prices);
    }
}

class FlowerShop {

    int people;
    List<Integer> prices;

    FlowerShop(int people, List<Integer> prices) {
        this.people = people;
        this.prices = prices;
    }

}
