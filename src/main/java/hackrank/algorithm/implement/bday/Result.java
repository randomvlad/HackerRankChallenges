package hackrank.algorithm.implement.bday;

/**
 * @see <a href="https://www.hackerrank.com/challenges/taum-and-bday">Taum and B'day</a>
 */
public class Result {

    /**
     * @param giftsBlack  Required number of black gifts
     * @param giftsWhite  Required number of white gifts
     * @param costBlack   Cost of a black gift
     * @param costWhite   Cost of a white gift
     * @param costConvert Cost to convert a black gift into white gift or vice versa
     * @return the minimum cost to purchase {@code giftsBlack} and {@code giftsWhite}.
     */
    public static long taumBday(int giftsBlack, int giftsWhite, int costBlack, int costWhite, int costConvert) {
        long totalBlack;
        if (costBlack > (costConvert + costWhite)) {
            totalBlack = ((long) giftsBlack) * (costConvert + costWhite);
        } else {
            totalBlack = ((long) giftsBlack) * costBlack;
        }

        long totalWhite;
        if (costWhite > (costConvert + costBlack)) {
            totalWhite = ((long) giftsWhite) * (costConvert + costBlack);
        } else {
            totalWhite = ((long) giftsWhite) * costWhite;
        }

        return totalBlack + totalWhite;
    }
}
