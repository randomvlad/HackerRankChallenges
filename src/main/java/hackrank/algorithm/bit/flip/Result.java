package hackrank.algorithm.bit.flip;

/**
 * @see <a href="https://www.hackerrank.com/challenges/flipping-bits">Flipping Bits</a>
 */
public class Result {

    public final static long MAX_32_BIT_UNSIGNED = 0xFFFF_FFFFL;

    /**
     * @param n 32-bit unsigned integer represented as a long
     * @return Flipped 32-bit unsigned integer represented as a long
     */
    public static long flippingBits(long n) {
        return n ^ MAX_32_BIT_UNSIGNED;
    }
}
