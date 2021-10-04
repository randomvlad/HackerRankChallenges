package hackrank.algorithm.string.funny;

/**
 * @see <a href="https://www.hackerrank.com/challenges/funny-string">Funny String</a>
 */
public class Result {

    /**
     * @param s value to check for funniness
     * @return "Funny" or "Not Funny" value.
     */
    public static String funnyString(String s) {
        return isFunny(s) ? "Funny" : "Not Funny";
    }

    private static boolean isFunny(String value) {
        if (value.length() < 2) {
            return false;
        }

        char[] reverse = new StringBuilder(value).reverse().toString().toCharArray();
        char[] characters = value.toCharArray();

        for (int i = 1; i < characters.length; i++) {
            if (Math.abs(characters[i] - characters[i - 1]) != Math.abs(reverse[i] - reverse[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
