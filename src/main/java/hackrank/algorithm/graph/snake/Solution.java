package hackrank.algorithm.graph.snake;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Snakes and Ladders Challenge
 *
 * @see https://www.hackerrank.com/challenges/the-quickest-way-up
 */
public class Solution {

    public static void main(String[] args) {

        for (Board board : readInput(System.in)) {
            System.out.println(board.calculateMoves(1, 100));
        }

    }

    private static List<Board> readInput(InputStream input) {
        Scanner scanner = new Scanner(input);

        int testCases = scanner.nextInt();

        List<Board> boards = new ArrayList<>(testCases);
        for (int i = 0; i < testCases; i++) {

            int numberLadders = scanner.nextInt();
            Map<Integer, Integer> ladders = new HashMap<>(numberLadders, 1.0f);
            for (int l = 0; l < numberLadders; l++) {
                ladders.put(scanner.nextInt(), scanner.nextInt());
            }

            int numberSnakes = scanner.nextInt();
            Map<Integer, Integer> snakes = new HashMap<>(numberSnakes, 1.0f);
            for (int s = 0; s < numberSnakes; s++) {
                snakes.put(scanner.nextInt(), scanner.nextInt());
            }

            boards.add(new Board(ladders, snakes));
        }

        scanner.close();

        return boards;
    }
}

class Board {

    public Map<Integer, Square> squares;
    public Map<Integer, Integer> ladders;
    public Map<Integer, Integer> snakes;

    public Board(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        this(100, ladders, snakes);
    }

    public Board(int numberSquares, Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        this.squares = new HashMap<>(numberSquares, 1.0f);
        this.ladders = ladders;
        this.snakes = snakes;

        initialize(numberSquares);
    }

    private void initialize(int numberSquares) {

        for (int squareId = 1; squareId <= numberSquares; squareId++) {
            add(squareId);
        }

        for (int squareId = 1; squareId < numberSquares; squareId++) {
            connect(squareId, findNextSquares(squareId));
        }
    }

    public List<Integer> findNextSquares(int startId) {
        List<Integer> next = new ArrayList<>();

        int max = startId + 6;
        max = max > squares.size() ? squares.size() : max;

        for (int id = startId + 1; id <= max; id++) {
            if (ladders.containsKey(id)) {
                next.add(ladders.get(id));
            } else if (snakes.containsKey(id)) {
                next.add(snakes.get(id));
            } else {
                next.add(id);
            }
        }

        return next;
    }

    public void add(int squareId) {
        squares.put(squareId, new Square(squareId));
    }

    public void connect(int idFrom, int idTo) {
        Square from = squares.get(idFrom);
        Square to = squares.get(idTo);
        from.connect(to, 1);
    }

    public void connect(int idFrom, List<Integer> idsTo) {
        for (int idTo : idsTo) {
            connect(idFrom, idTo);
        }
    }

    private void computePaths(Square squareStart) {

        squareStart.minDistance = 0;
        PriorityQueue<Square> vertexQueue = new PriorityQueue<Square>();
        vertexQueue.add(squareStart);

        while (!vertexQueue.isEmpty()) {
            Square squareFrom = vertexQueue.poll();

            for (Connection connection : squareFrom.connections) {
                Square nodeTo = connection.target;

                int distanceTo = squareFrom.minDistance + connection.weight;

                if (distanceTo < nodeTo.minDistance) {
                    vertexQueue.remove(nodeTo);

                    nodeTo.minDistance = distanceTo;
                    nodeTo.previous = squareFrom;
                    vertexQueue.add(nodeTo);
                }
            }
        }
    }

    public List<Square> findPathTo(int startId, int endId) {
        Square start = squares.get(startId);

        computePaths(start);

        List<Square> path = new ArrayList<Square>();
        Square end = squares.get(endId);

        if (end.previous != null) {
            for (Square square = end; square != null; square = square.previous) {
                path.add(square);
            }
        }

        Collections.reverse(path);
        return path;
    }

    public int calculateMoves(int startId, int endId) {
        return findPathTo(startId, endId).size() - 1;
    }
}

class Square implements Comparable<Square> {

    public int id;
    public List<Connection> connections;

    public int minDistance = Integer.MAX_VALUE;
    public Square previous;

    public Square(int id) {
        this.id = id;
        this.connections = new ArrayList<>();
    }

    public void connect(Square square, int weight) {
        connections.add(new Connection(square, weight));
    }

    @Override public String toString() {
        return String.valueOf(id);
    }

    @Override public int compareTo(Square other) {
        return Integer.compare(minDistance, other.minDistance);
    }
}

class Connection {

    public Square target;
    public int weight;

    public Connection(Square target, int weight) {
        this.target = target;
        this.weight = weight;
    }

}
