package hackrank.algorithm.bit.maxxor;

/**
 * @see <a href="https://www.hackerrank.com/challenges/maximizing-xor">Maximizing XOR</a>
 */
public class Result {

    /**
     * @param l Lower bound integer (inclusive)
     * @param r Upper bound integer (inclusive)
     * @return Max xor operation value for all permutations of the integers between {@code l} and {@code r}
     */
    public static int maximizingXor(int l, int r) {
        int bestMax = 0;
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                int max = i ^ j;
                if (max > bestMax) {
                    bestMax = max;
                }
            }
        }
        return bestMax;
    }
}
