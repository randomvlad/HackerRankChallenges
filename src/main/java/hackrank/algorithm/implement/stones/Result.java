package hackrank.algorithm.implement.stones;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @see <a href="https://www.hackerrank.com/challenges/manasa-and-stones">Manasa and Stones</a>
 */
public class Result {

    /**
     * @param numberStones number of non-zero stones
     * @param diff1        one possible integer difference
     * @param diff2        another possible integer difference
     * @return List of all possible values of the last stone, sorted ascending
     */
    public static List<Integer> stones(int numberStones, int diff1, int diff2) {
        SortedSet<Integer> endings = new TreeSet<>();

        for (int a = 0; a < numberStones; a++) {
            int b = numberStones - 1 - a;

            int ending = a * diff1 + b * diff2;

            endings.add(ending);
        }

        return new ArrayList<>(endings);
    }
}
