package hackrank.algorithm.implement.angryprof;

import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/angry-professor">Angry Professor</a>
 */
public class Result {

    /**
     * @param k Minimum number of on time students required to not cancel class.
     * @param a List of student arrival times. Negative or equal to zero is on time. Positive number implies late.
     * @return "YES" if professor is angry at lack of punctual students and cancels class. Otherwise, "NO".
     */
    public static String angryProfessor(int k, List<Integer> a) {

        // start out as always angry - professor should really see somebody about that
        boolean angryCancelClass = true;

        int numberStudentsOnTime = 0;
        for (int arrivalTime : a) {
            if (arrivalTime <= 0) {
                numberStudentsOnTime++;
            }

            if (numberStudentsOnTime >= k) {
                angryCancelClass = false; // enough students are on time; don't cancel class
                break;
            }
        }

        return angryCancelClass ? "YES" : "NO";
    }
}
