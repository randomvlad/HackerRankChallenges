package hackrank.algorithm.implement.sherlock;

/**
 * @see <a href="https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem">Sherlock and The Beast</a>
 */
public class Result {

    private static final String BLOCK_DECENT_FIVES = "555";
    private static final String BLOCK_DECENT_THREES = "33333";

    /**
     * <p>
     * Print the decent number for the given length {@code n}, or -1 if a decent number of that length cannot be
     * formed.
     * </p>
     * A Decent Number has the following properties:
     * <ol>
     *     <li>Its digits can only be 3's and/or 5's.</li>
     *     <li>The number of 3's it contains is divisible by 5.</li>
     *     <li>The number of 5's it contains is divisible by 3.</li>
     *     <li>It is the largest such number for its length.</li>
     * </ol>
     *
     * @param n Length of decent number.
     */
    public static void decentNumber(int n) {
        System.out.println(findDecentNumber(n));
    }

    public static String findDecentNumber(int length) {
        switch (length % 3) {
            case 0:
                return repeat(BLOCK_DECENT_FIVES, length / 3);
            case 1:
                if (length - 10 >= 0) {
                    String fillerLengthTen = BLOCK_DECENT_THREES + BLOCK_DECENT_THREES;
                    return repeat(BLOCK_DECENT_FIVES, ((length - 10) / 3)) + fillerLengthTen;
                }
            case 2:
                if (length - 3 >= 0) {
                    return repeat(BLOCK_DECENT_FIVES, ((length - 3) / 3)) + BLOCK_DECENT_THREES;
                }
        }

        return "-1";
    }

    /**
     * Surprisingly until Java 11, there was no convenient method (not counting 3rd party libraries) to repeat a
     * string.
     *
     * @see <a href="https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string">Simple way to repeat a
     * string</a>
     */
    private static String repeat(String value, int times) {
        return new String(new char[times]).replace("\0", value);
    }
}
