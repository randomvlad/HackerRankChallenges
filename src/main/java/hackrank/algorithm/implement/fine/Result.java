package hackrank.algorithm.implement.fine;

import java.time.LocalDate;

/**
 * @see <a href="https://www.hackerrank.com/challenges/library-fine">Library Fine</a>
 */
public class Result {

    /**
     * @param returnDay   returned date day of month
     * @param returnMonth returned date month
     * @param returnYear  returned date year
     * @param dueDay      due date day of month
     * @param dueMonth    due date month
     * @param dueYear     due date year
     * @return The amount of the fine or 0 if there is none
     */
    public static int libraryFine(int returnDay, int returnMonth, int returnYear, int dueDay, int dueMonth,
            int dueYear) {
        LocalDate returnDate = LocalDate.of(returnYear, returnMonth, returnDay);
        LocalDate dueDate = LocalDate.of(dueYear, dueMonth, dueDay);

        if (returnDate.compareTo(dueDate) <= 0) {
            return 0;
        }

        if (returnDate.getYear() != dueDate.getYear()) {
            return 10000;
        } else if (returnDate.getMonthValue() != dueDate.getMonthValue()) {
            return 500 * (returnDate.getMonthValue() - dueDate.getMonthValue());
        } else {
            return 15 * (returnDate.getDayOfMonth() - dueDate.getDayOfMonth());
        }
    }
}
