package hackrank.algorithm.greedy.jimorder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Jim and the Orders Challenge
 *
 * @see https://www.hackerrank.com/challenges/jim-and-the-orders
 */
public class Solution {

    public static void main(String[] args) {

        List<Order> orders = readInput(System.in);

        Collections.sort(orders);

        System.out.println(orders.stream().map(o -> String.valueOf(o.id)).collect(Collectors.joining(" ")));
    }

    public static List<Order> readInput(InputStream input) {

        Scanner scanner = new Scanner(input);

        int numberOrders = scanner.nextInt();
        List<Order> orders = new ArrayList<>(numberOrders);

        for (int orderId = 1; orderId <= numberOrders; orderId++) {
            orders.add(new Order(orderId, scanner.nextInt(), scanner.nextInt()));
        }

        scanner.close();

        return orders;
    }

}

class Order implements Comparable<Order> {

    int id;
    int start;
    int cost;

    Order(int id, int start, int cost) {
        this.id = id;
        this.start = start;
        this.cost = cost;
    }

    public int compareTo(Order another) {
        int diff = (start + cost) - (another.start + another.cost);
        if (diff == 0) {
            return id - another.id;
        } else {
            return diff;
        }
    }
}
