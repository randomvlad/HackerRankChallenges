package hackrank.algorithm.string.palindrome;

/**
 * @see <a href="https://www.hackerrank.com/challenges/palindrome-index">Palindrome Index</a>
 */
public class Result {

    /**
     * @param s string of lowercase letters in ASCII range a-z
     * @return index of the character to remove from {@code s} to make a palindrome. -1 if it is not possible
     */
    public static int palindromeIndex(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar == rightChar) {
                continue;
            }

            if (isPalindrome(s, left, right)) { // try without character at "right" index
                return right;
            } else if (isPalindrome(s, left + 1, right + 1)) { // try without character at "left" index
                return left;
            } else {
                return -1;
            }
        }

        return -1;
    }

    private static boolean isPalindrome(String value, int startIndex, int endIndex) {
        for (int left = startIndex, right = endIndex - 1; left < right; left++, right--) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
