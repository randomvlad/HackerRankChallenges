package hackrank.algorithm.implement.grid;

import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/the-grid-search">The Grid Search</a>
 */
public class Result {

    /**
     * @param gridData    List of string rows in a grid
     * @param patternData List of string rows to search for
     * @return "YES" if {@code patternData} exists in the grid, or "NO" otherwise.
     */
    public static String gridSearch(List<String> gridData, List<String> patternData) {
        Grid grid = Grid.create(gridData);
        Grid pattern = Grid.create(patternData);

        int maxRow = grid.getNumberRows() - pattern.getNumberRows();
        int maxColumn = grid.getNumberColumns() - pattern.getNumberColumns();

        for (int r = 0; r <= maxRow; r++) {
            for (int c = 0; c <= maxColumn; c++) {
                if (contains(grid, pattern, r, c)) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    private static boolean contains(Grid grid, Grid pattern, int startRow, int startColumn) {
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

    private static class Grid {

        private final int[][] data;

        private Grid(int[][] data) {
            this.data = data;
        }

        public int get(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        public int getNumberRows() {
            return data.length;
        }

        public int getNumberColumns() {
            return data[0].length;
        }

        public static Grid create(List<String> rowValues) {
            int numberRows = rowValues.size();
            int numberColumns = rowValues.get(0).length();
            int[][] data = new int[numberRows][numberColumns];

            for (int rowIndex = 0; rowIndex < rowValues.size(); rowIndex++) {
                char[] row = rowValues.get(rowIndex).toCharArray();

                for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                    char character = row[columnIndex];
                    data[rowIndex][columnIndex] = Character.getNumericValue(character);
                }
            }

            return new Grid(data);
        }
    }
}
