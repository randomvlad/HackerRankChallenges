package hackrank.algorithm.bit.lonely;

import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/lonely-integer">Lonely Integer</a>
 */
public class Result {

    /**
     * @param numbers List of integers where every number is present twice except for a single lonely number.
     * @return Integer number that occurs only once.
     */
    public static int lonelyinteger(List<Integer> numbers) {
        int lonely = 0;
        for (int number : numbers) {
            lonely ^= number;
        }
        return lonely;
    }
}
