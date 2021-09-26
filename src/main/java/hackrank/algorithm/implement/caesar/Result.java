package hackrank.algorithm.implement.caesar;

/**
 * @see <a href="https://www.hackerrank.com/challenges/caesar-cipher-1">Caesar Cipher</a>
 */
public class Result {

    public final static int ALPHABET_ENGLISH_SIZE = 26;
    public final static int LAST_LETTER_UPPER_CASE = 'Z';
    public final static int LAST_LETTER_LOWER_CASE = 'z';

    /**
     * @param value        ASCII string value to rotate. Contains no spaces
     * @param rotateFactor alphabet letter rotation factor
     * @return String value after rotating each alphabet letter by {@code rotateFactor}
     */
    public static String caesarCipher(String value, int rotateFactor) {
        StringBuilder cipher = new StringBuilder();
        for (char character : value.toCharArray()) {
            cipher.append(rotate(character, rotateFactor));
        }
        return cipher.toString();
    }

    private static char rotate(char character, int rotateFactor) {
        if (!Character.isLetter(character)) {
            return character;
        }

        int rotated = (int) character + (rotateFactor % ALPHABET_ENGLISH_SIZE);

        int wrapAroundBoundary = Character.isUpperCase(character) ? LAST_LETTER_UPPER_CASE : LAST_LETTER_LOWER_CASE;
        if (rotated > wrapAroundBoundary) {
            rotated -= ALPHABET_ENGLISH_SIZE;
        }

        return (char) rotated;
    }

}
