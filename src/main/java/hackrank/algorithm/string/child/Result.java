package hackrank.algorithm.string.child;

/**
 * @see <a href="https://www.hackerrank.com/challenges/common-child">Common Child</a>
 */
public class Result {

    /**
     * @param s1 first value
     * @param s2 second value
     * @return length of the longest string which is a common child of {@code s1} and {@code s2}
     */
    public static int commonChild(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        return matrix[s1.length()][s2.length()];
    }
}
