package hackrank.algorithm.implement.chocolate;

/**
 * @see <a href="https://www.hackerrank.com/challenges/chocolate-feast">Chocolate Feast</a>
 */
public class Result {

    /**
     * @param moneyAmount         initial amount of money to spend on chocolate bars
     * @param chocolatePrice      price for a single chocolate bar
     * @param wrapperExchangeRate number of wrappers needed to exchange for a chocolate bar
     * @return total number of chocolate bars eaten
     */
    public static int chocolateFeast(int moneyAmount, int chocolatePrice, int wrapperExchangeRate) {
        int totalEaten = 0;
        int wrappers = 0;

        while (moneyAmount >= chocolatePrice) {
            int chocolates = moneyAmount / chocolatePrice;
            moneyAmount = moneyAmount % chocolatePrice;

            wrappers += chocolates;
            totalEaten += chocolates;

            moneyAmount += wrappers / wrapperExchangeRate * chocolatePrice;
            wrappers = wrappers % wrapperExchangeRate;
        }

        return totalEaten;
    }
}
