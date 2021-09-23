package hackrank.datastruct.heap.runningmedian;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://www.hackerrank.com/challenges/find-the-running-median">Find the Running Median</a>
 */
public class Result {

    /**
     * @param a List of integers in a data stream
     * @return List of median values after each integer in data stream
     */
    public static List<Double> runningMedian(List<Integer> a) {

        // max heap to keep track of numbers lesser "left" than the center
        PriorityQueue<Integer> lesserLeft = new PriorityQueue<>(Comparator.reverseOrder());

        // min heap to keep track of numbers greater "right" than the center
        PriorityQueue<Integer> greaterRight = new PriorityQueue<>();

        List<Double> runningMedians = new ArrayList<>(a.size());

        for (Integer number : a) {
            if (lesserLeft.isEmpty() || lesserLeft.peek() >= number) {
                lesserLeft.add(number);
            } else {
                greaterRight.add(number);
            }

            int difference = Math.abs(lesserLeft.size() - greaterRight.size());
            if (difference > 1) {
                balance(lesserLeft, greaterRight);
            }

            Double median = getMedian(lesserLeft, greaterRight);
            runningMedians.add(median);
        }

        return runningMedians;
    }

    private static Double getMedian(PriorityQueue<Integer> lesserLeft, PriorityQueue<Integer> greaterRight) {
        if (lesserLeft.size() > greaterRight.size()) {
            return Double.valueOf(lesserLeft.peek());
        } else if (lesserLeft.size() < greaterRight.size()) {
            return Double.valueOf(greaterRight.peek());
        } else {
            double sum = (double) lesserLeft.peek() + greaterRight.peek();
            return sum / 2;
        }
    }

    private static void balance(PriorityQueue<Integer> lesserLeft, PriorityQueue<Integer> greaterRight) {
        if (lesserLeft.size() > greaterRight.size()) {
            Integer number = lesserLeft.poll();
            greaterRight.add(number);
        } else {
            Integer number = greaterRight.poll();
            lesserLeft.add(number);
        }
    }
}
