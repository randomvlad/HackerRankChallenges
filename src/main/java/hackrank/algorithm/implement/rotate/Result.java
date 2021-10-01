package hackrank.algorithm.implement.rotate;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/matrix-rotation-algo">Matrix Layer Rotation</a>
 */
public class Result {

    /**
     * @param matrix    2D list of integers.
     * @param rotations Number of times to rotate in anti-clockwise direction.
     */
    public static void matrixRotation(List<List<Integer>> matrix, int rotations) {
        rotateMatrixLayers(matrix, rotations);
        System.out.println(getStringDisplay(matrix));
    }

    public static void rotateMatrixLayers(List<List<Integer>> matrix, int rotations) {
        List<MatrixLayer> layers = getLayers(matrix);

        for (MatrixLayer layer : layers) {
            int rotate = rotations % layer.numberCells;
            for (int i = 0; i < rotate; i++) {
                rotateLayer(matrix, layer);
            }
        }
    }

    private static List<MatrixLayer> getLayers(List<List<Integer>> matrix) {
        List<MatrixLayer> layers = new ArrayList<>();

        int matrixRows = matrix.size();
        int matrixColumns = matrix.get(0).size();

        for (int layerIndex = 0; layerIndex < matrixRows; layerIndex++) {
            int layerRows = matrixRows - 2 * layerIndex;
            int layerColumns = matrixColumns - 2 * layerIndex;

            if (layerRows > 1 && layerColumns > 1) {
                layers.add(new MatrixLayer(layerIndex, layerRows, layerColumns));
            }
        }

        return layers;
    }

    private static void rotateLayer(List<List<Integer>> matrix, MatrixLayer layer) {
        int rowIndex = layer.rowIndexMin;
        int columnIndex = layer.columnIndexMin;

        int replaced = matrix.get(rowIndex).get(columnIndex);

        for (int i = 0; i < layer.numberCells; i++) {
            int[] nextCell = layer.getNextCell(rowIndex, columnIndex);
            int rowNext = nextCell[0];
            int colNext = nextCell[1];

            int temp = matrix.get(rowNext).get(colNext);
            matrix.get(rowNext).set(colNext, replaced);
            replaced = temp;

            columnIndex = colNext;
            rowIndex = rowNext;
        }
    }

    /**
     * Helper method to display {@code matrix} as a string.
     */
    static String getStringDisplay(List<List<Integer>> matrix) {
        StringBuilder sb = new StringBuilder();
        for (int rowIndex = 0; rowIndex < matrix.size(); rowIndex++) {
            if (rowIndex > 0) {
                sb.append(System.lineSeparator());
            }

            for (int columnIndex = 0; columnIndex < matrix.get(0).size(); columnIndex++) {
                if (columnIndex > 0) {
                    sb.append(" ");
                }

                sb.append(matrix.get(rowIndex).get(columnIndex));
            }
        }
        return sb.toString();
    }

    private static class MatrixLayer {

        private final int rowIndexMin;
        private final int rowIndexMax;
        private final int columnIndexMin;
        private final int columnIndexMax;
        private final int numberCells;

        MatrixLayer(int index, int numberRows, int numberColumns) {
            this.rowIndexMin = index;
            this.rowIndexMax = index + numberRows - 1;
            this.columnIndexMin = index;
            this.columnIndexMax = index + numberColumns - 1;
            this.numberCells = 2 * (numberRows + numberColumns - 2);
        }

        /**
         * @return Row and column index of next cell in anti-clockwise direction.
         */
        int[] getNextCell(int currentRowIndex, int currentColumnIndex) {
            int nextRowIndex = currentRowIndex;
            int nextColumnIndex = currentColumnIndex;

            if (currentRowIndex == rowIndexMin && currentColumnIndex > columnIndexMin) {
                nextColumnIndex += -1; // column index moves right to left along row
            } else if (currentColumnIndex == columnIndexMax && currentRowIndex > rowIndexMin) {
                nextRowIndex += -1; // row index moves bottom to top along column
            } else if (currentRowIndex == rowIndexMax && currentColumnIndex < columnIndexMax) {
                nextColumnIndex += 1; // column index moves left to right along row
            } else if (currentColumnIndex == columnIndexMin && currentRowIndex < rowIndexMax) {
                nextRowIndex += 1; // row index moves top to bottom along column
            }

            return new int[] { nextRowIndex, nextColumnIndex };
        }
    }
}
