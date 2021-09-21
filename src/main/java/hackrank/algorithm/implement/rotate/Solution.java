package hackrank.algorithm.implement.rotate;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Matrix Rotation Challenge
 *
 * @see https://www.hackerrank.com/challenges/matrix-rotation-algo
 */
public class Solution {

    public static void main(String[] args) {

        MatrixRotater rotater = readInput(System.in);
        System.out.println(rotater.rotate().toString());
    }

    public static MatrixRotater readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int rotations = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        return new MatrixRotater(matrix, rotations);
    }
}

class MatrixRotater {

    private int[][] matrix;
    private int rotations;

    public MatrixRotater(int[][] matrix, int rotations) {
        this.matrix = matrix;
        this.rotations = rotations;
    }

    public MatrixRotater rotate() {

        for (int layerIndex = 0; layerIndex < getNumberRows(); layerIndex++) {

            int[] dimensions = getLayerDimensions(layerIndex);
            int rows = dimensions[0];
            int columns = dimensions[1];
            if (rows <= 1 || columns <= 1) {
                continue;
            }

            int rotate = rotations % countLayerCells(rows, columns);
            for (int i = 0; i < rotate; i++) {
                rotateLayer(matrix, layerIndex, rows, columns);
            }
        }

        return this;
    }

    private void rotateLayer(int[][] matrix, int layerIndex, int rows, int columns) {

        int c = layerIndex;
        int r = layerIndex;

        int replaced = matrix[r][c];

        int numberSwaps = countLayerCells(rows, columns);
        for (int i = 0; i < numberSwaps; i++) {

            int[] steps = calcStepIncrement(r, c, layerIndex, rows, columns);

            int rowNext = r + steps[0];
            int colNext = c + steps[1];

            int temp = matrix[rowNext][colNext];
            matrix[rowNext][colNext] = replaced;
            replaced = temp;

            c = colNext;
            r = rowNext;
        }
    }

    private int countLayerCells(int rows, int columns) {
        return 2 * (rows + columns - 2);
    }

    private int[] getLayerDimensions(int layerIndex) {

        int rows = getNumberRows() - 2 * layerIndex;
        int columns = getNumberColumns() - 2 * layerIndex;

        return new int[] { rows >= 1 ? rows : 0, columns >= 1 ? columns : 0 };
    }

    private int[] calcStepIncrement(int r, int c, int layerIndex, int rows, int columns) {

        int rowMin = layerIndex;
        int rowMax = rowMin + rows - 1;
        int colMin = layerIndex;
        int colMax = colMin + columns - 1;

        int colStep = 0;
        int rowStep = 0;

        if (r == rowMin && c > colMin) {
            // column index moves right to left along row
            colStep = -1;
        } else if (c == colMax && r > rowMin) {
            // row index moves bottom to top along column
            rowStep = -1;
        } else if (r == rowMax && c < colMax) {
            // column index moves left to right along row
            colStep = 1;
        } else if (c == colMin && r < rowMax) {
            // row index moves top to bottom along column
            rowStep = 1;
        }

        return new int[] { rowStep, colStep };
    }

    @Override public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getNumberRows(); i++) {
            if (i > 0) {
                sb.append(System.lineSeparator());
            }

            for (int j = 0; j < getNumberColumns(); j++) {
                if (j > 0) {
                    sb.append(" ");
                }

                sb.append(matrix[i][j]);
            }
        }

        return sb.toString();
    }

    public int getNumberColumns() {
        return matrix[0].length;
    }

    public int getNumberRows() {
        return matrix.length;
    }

}
