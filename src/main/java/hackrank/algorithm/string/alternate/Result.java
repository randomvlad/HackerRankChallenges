package hackrank.algorithm.string.alternate;

/**
 * @see <a href="https://www.hackerrank.com/challenges/alternating-characters">Alternating Characters</a>
 */
public class Result {

    /**
     * @param s value containing only A and B characters
     * @return Minimum number of deletions required
     */
    public static int alternatingCharacters(String s) {
        char[] characters = s.toCharArray();
        int deletions = 0;

        for (int i = 1; i < characters.length; i++) {
            char previous = characters[i - 1];
            char current = characters[i];

            if (previous == current) {
                deletions++;
            }
        }

        return deletions;
    }
}
