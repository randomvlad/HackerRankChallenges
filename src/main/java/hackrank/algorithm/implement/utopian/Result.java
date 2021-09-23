package hackrank.algorithm.implement.utopian;

/**
 * @see <a href="https://www.hackerrank.com/challenges/utopian-tree">Utopian Tree</a>
 */
public class Result {

    /**
     * @param n Number of growth cycles
     * @return The height of the tree after {@code n} cycles
     */
    public static int utopianTree(int n) {
        return findUtopianTreeHeight(1, n);
    }

    private static int findUtopianTreeHeight(int height, int numberCycles) {
        if (numberCycles == 0) {
            return height;
        } else if (numberCycles == 1) {
            return height * 2;
        } else if (numberCycles == 2) {
            return height * 2 + 1;
        } else {
            return findUtopianTreeHeight(height * 2 + 1, numberCycles - 2);
        }
    }
}
