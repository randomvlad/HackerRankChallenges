package hackrank.algorithm.greedy.boardcut;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Cutting Boards Challenge
 *
 * @see https://www.hackerrank.com/challenges/board-cutting
 */
public class Solution {

    public static void main(String[] args) {

        for (Board board : readInput(System.in)) {
            System.out.println(board.findMinCutCost() % 1_000_000_007);
        }
    }

    public static List<Board> readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        int size = scanner.nextInt();
        List<Board> boards = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {

            int height = scanner.nextInt();
            int width = scanner.nextInt();

            List<Long> costHeights = new ArrayList<>(height - 1);
            for (int h = 0; h < height - 1; h++) {
                costHeights.add(scanner.nextLong());
            }

            List<Long> costWidths = new ArrayList<>(width - 1);
            for (int w = 0; w < width - 1; w++) {
                costWidths.add(scanner.nextLong());
            }

            boards.add(new Board(costHeights, costWidths));
        }

        scanner.close();

        return boards;
    }

}

class Board {

    private List<Long> costHeight;
    private List<Long> costWidth;

    Board(List<Long> costHeight, List<Long> costWidth) {
        this.costHeight = costHeight;
        this.costWidth = costWidth;
    }

    public long findMinCutCost() {

        Collections.sort(costHeight, Collections.reverseOrder());
        Collections.sort(costWidth, Collections.reverseOrder());

        int h = 0;
        int w = 0;
        int segmentsWidth = 1;
        int segmentsHeight = 1;
        long cost = 0;

        while (h < costHeight.size() || w < costWidth.size()) {

            long costWidth = getCostWidth(w);
            long costHeight = getCostHeight(h);

            if (costWidth > costHeight) {
                cost += costWidth * segmentsHeight;
                segmentsWidth++;
                w++;
            } else {
                cost += costHeight * segmentsWidth;
                segmentsHeight++;
                h++;
            }
        }

        return cost;
    }

    public long getCostHeight(int index) {
        return index >= 0 && index < costHeight.size() ? costHeight.get(index) : -1;
    }

    public long getCostWidth(int index) {
        return index >= 0 && index < costWidth.size() ? costWidth.get(index) : -1;
    }

}
