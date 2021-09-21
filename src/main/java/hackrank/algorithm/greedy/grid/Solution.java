package hackrank.algorithm.greedy.grid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Grid Challenge
 *
 * @see https://www.hackerrank.com/challenges/grid-challenge
 */
public class Solution {

    public static void main(String[] args) {

        for (Grid grid : readInput(System.in)) {
            System.out.println((isColumnRowSortPossible(grid) ? "YES" : "NO"));
        }
    }

    public static boolean isColumnRowSortPossible(Grid grid) {

        for (char[] row : grid.matrix) {
            Arrays.sort(row);
        }

        for (int columnIndex = 0; columnIndex < grid.size(); columnIndex++) {
            if (!grid.isColumnSorted(columnIndex)) {
                return false;
            }
        }

        return true;
    }

    public static List<Grid> readInput(InputStream input) {

        Scanner scanner = new Scanner(input);

        int numberTests = scanner.nextInt();

        List<Grid> grids = new ArrayList<>();

        for (int t = 0; t < numberTests; t++) {
            int size = scanner.nextInt();

            char[][] matrix = new char[size][];
            for (int i = 0; i < size; i++) {
                matrix[i] = scanner.next().toCharArray();
            }

            grids.add(new Grid(matrix));
        }

        scanner.close();

        return grids;
    }
}

class Grid {

    char[][] matrix;

    Grid(char[][] matrix) {
        this.matrix = matrix;
    }

    public int size() {
        return matrix.length;
    }

    public boolean isColumnSorted(int columnIndex) {

        for (int rowIndex = 1; rowIndex < matrix.length; rowIndex++) {

            char prev = matrix[rowIndex - 1][columnIndex];
            char current = matrix[rowIndex][columnIndex];

            if (prev > current) {
                return false;
            }
        }

        return true;
    }

    @Override public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Grid " + this.matrix.length + "x" + this.matrix.length + ":" + System.lineSeparator());

        for (char[] row : matrix) {

            sb.append("\t");
            for (char c : row) {
                sb.append(c + " ");
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

}
