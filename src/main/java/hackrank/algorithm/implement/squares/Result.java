package hackrank.algorithm.implement.squares;

/**
 * @see <a href="https://www.hackerrank.com/challenges/sherlock-and-squares">Sherlock and Squares</a>
 */
public class Result {

    /**
     * @param a inclusive start number for lower range boundary
     * @param b inclusive end number for upper range boundary
     * @return the number of square integers in the range {@code a} to {@code b}
     */
    public static int squares(int a, int b) {
        int squareStart = (int) Math.ceil(Math.sqrt(a));
        int squareEnd = (int) Math.floor(Math.sqrt(b));
        return squareStart <= squareEnd ? (squareEnd - squareStart + 1) : 0;
    }
}
