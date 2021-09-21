package hackrank.algorithm.implement.grid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Grid Search Challenge
 *
 * @see https://www.hackerrank.com/challenges/the-grid-search
 */
public class Solution {

    public static void main(String[] args) {

        for (Grid[] gridPatterns : readInput(System.in)) {
            Grid grid = gridPatterns[0];
            Grid pattern = gridPatterns[1];
            System.out.println((contains(grid, pattern) ? "YES" : "NO"));
        }

    }

    public static boolean contains(Grid grid, Grid pattern) {

        int maxRow = grid.getNumberRows() - pattern.getNumberRows();
        int maxColumn = grid.getNumberColumns() - pattern.getNumberColumns();

        for (int r = 0; r <= maxRow; r++) {
            for (int c = 0; c <= maxColumn; c++) {
                if (contains(grid, pattern, r, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean contains(Grid grid, Grid pattern, int startRow, int startColumn) {

        int maxRow = startRow + pattern.getNumberRows() - 1;
        int maxColumn = startColumn + pattern.getNumberColumns() - 1;

        for (int r = startRow, pr = 0; r <= maxRow; r++, pr++) {
            for (int c = startColumn, pc = 0; c <= maxColumn; c++, pc++) {
                if (grid.get(r, c) != pattern.get(pr, pc)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static List<Grid[]> readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        int testCases = scanner.nextInt();
        List<Grid[]> grids = new ArrayList<>(testCases);

        for (int t = 0; t < testCases; t++) {

            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            int[][] gridData = new int[rows][columns];
            for (int r = 0; r < rows; r++) {

                String row = scanner.next();
                for (int c = 0; c < columns; c++) {
                    gridData[r][c] = Integer.valueOf(row.charAt(c) + "");
                }
            }

            rows = scanner.nextInt();
            columns = scanner.nextInt();

            int[][] patternData = new int[rows][columns];
            for (int r = 0; r < rows; r++) {

                String row = scanner.next();
                for (int c = 0; c < columns; c++) {
                    patternData[r][c] = Integer.valueOf(row.charAt(c) + "");
                }
            }

            grids.add(new Grid[] { new Grid(gridData), new Grid(patternData) });
        }

        scanner.close();

        return grids;
    }

}

class Grid {

    int[][] data;

    Grid(int[][] data) {
        this.data = data;
    }

    public int get(int i, int j) {
        return data[i][j];
    }

    public int getNumberRows() {
        return data.length;
    }

    public int getNumberColumns() {
        return data[0].length;
    }
}
