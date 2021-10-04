package hackrank.algorithm.bit.sansa;

import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/sansa-and-xor">Sansa and XOR</a>
 */
public class Result {

    /**
     * @param numbers List of integers
     * @return Number obtained by xor-ing all contiguous subarrays of {@code numbers}
     */
    public static int sansaXor(List<Integer> numbers) {
        if (numbers.size() % 2 == 0) {
            return 0;
        } else {
            int total = 0;
            for (int i = 0; i < numbers.size(); i += 2) {
                total ^= numbers.get(i);
            }
            return total;
        }
    }
}
