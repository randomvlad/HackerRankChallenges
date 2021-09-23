package hackrank.algorithm.implement.digit;

/**
 * @see <a href="https://www.hackerrank.com/challenges/find-digits">Find Digits</a>
 */
public class Result {

    /**
     * @param n Integer value to analyze
     * @return Total count of divisors contained in {@code n}
     */
    public static int findDigits(int n) {
        int count = 0;

        for (char charDigit : String.valueOf(n).toCharArray()) {
            int digit = Character.getNumericValue(charDigit);
            if (digit != 0 && n % digit == 0) {
                count++;
            }
        }

        return count;
    }
}
