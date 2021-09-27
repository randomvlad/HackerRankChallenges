package hackrank.algorithm.implement.cavity;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/cavity-map">Cavity Map</a>
 */
public class Result {

    /**
     * @param gridData List of string rows in the grid
     * @return A list string rows of the modified grid. Cavities are marked with uppercase 'X' character.
     */
    public static List<String> cavityMap(List<String> gridData) {
        Grid grid = Grid.create(gridData);

        List<String> gridCavities = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < grid.size(); rowIndex++) {
            StringBuilder rowCavities = new StringBuilder();

            for (int columnIndex = 0; columnIndex < grid.size(); columnIndex++) {
                String cell =
                        isCavity(grid, rowIndex, columnIndex) ? "X" : String.valueOf(grid.get(rowIndex, columnIndex));
                rowCavities.append(cell);
            }

            gridCavities.add(rowCavities.toString());
        }

        return gridCavities;
    }

    private static boolean isCavity(Grid grid, int rowIndex, int columnIndex) {
        int minIndex = 0;
        int maxIndex = grid.size() - 1;

        if (rowIndex == minIndex || rowIndex == maxIndex || columnIndex == minIndex || columnIndex == maxIndex) {
            return false;
        }

        int cellCenter = grid.get(rowIndex, columnIndex);

        int cellUp = grid.get(rowIndex - 1, columnIndex);
        int cellDown = grid.get(rowIndex + 1, columnIndex);
        int cellLeft = grid.get(rowIndex, columnIndex - 1);
        int cellRight = grid.get(rowIndex, columnIndex + 1);

        return cellCenter > cellUp && cellCenter > cellDown && cellCenter > cellLeft && cellCenter > cellRight;
    }

    private static class Grid {

        private final int[][] data;

        Grid(int[][] data) {
            this.data = data;
        }

        public int get(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        public int size() {
            return data.length;
        }

        public static Grid create(List<String> rows) {
            int[][] gridData = new int[rows.size()][rows.size()];

            for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
                char[] cells = rows.get(rowIndex).toCharArray();
                for (int columnIndex = 0; columnIndex < cells.length; columnIndex++) {
                    gridData[rowIndex][columnIndex] = Character.getNumericValue(cells[columnIndex]);
                }
            }

            return new Grid(gridData);
        }
    }
}
