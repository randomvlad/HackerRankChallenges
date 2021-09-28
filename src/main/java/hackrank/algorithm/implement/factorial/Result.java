package hackrank.algorithm.implement.factorial;

import java.math.BigInteger;

/**
 * @see <a href="https://www.hackerrank.com/challenges/extra-long-factorials">Extra Long Factorials</a>
 */
public class Result {

    /**
     * @param number Factorial integer to calculate
     */
    public static void extraLongFactorials(int number) {
        System.out.println(calculateFactorial(number));
    }

    public static BigInteger calculateFactorial(int number) {
        BigInteger total = BigInteger.valueOf(number);
        for (int i = number - 1; i > 1; i--) {
            total = total.multiply(BigInteger.valueOf(i));
        }
        return total;
    }
}
