package hackrank.algorithm.graph.bfsreach;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Breadth First Search: Shortest Reach
 *
 * @see https://www.hackerrank.com/challenges/bfsshortreach
 */
public class Solution {

    public static void main(String[] args) {
        for (Graph graph : readInput(System.in)) {
            graph.computeDistancesFromStart();
            List<Integer> distances = graph.findDistancesFromStart();
            System.out.println(distances.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
        }
    }

    private static List<Graph> readInput(InputStream input) {
        Scanner scanner = new Scanner(input);

        int testCases = scanner.nextInt();

        List<Graph> graphs = new ArrayList<>(testCases);
        for (int i = 0; i < testCases; i++) {

            int numberNodes = scanner.nextInt();
            int numberEdges = scanner.nextInt();

            int[][] edges = new int[numberEdges][];
            for (int e = 0; e < numberEdges; e++) {
                edges[e] = new int[] { scanner.nextInt(), scanner.nextInt() };
            }

            int startNodeId = scanner.nextInt();

            graphs.add(new Graph(numberNodes, edges, startNodeId));
        }

        scanner.close();

        return graphs;
    }
}

class Graph {

    public Map<Integer, Node> nodes;
    public int startNodeId;

    public Graph(int numberNodes, int[][] edges, int startNodeId) {
        this.nodes = new HashMap<>(numberNodes, 1.0f);

        for (int nodeId = 1; nodeId <= numberNodes; nodeId++) {
            nodes.put(nodeId, new Node(nodeId));
        }

        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }

        this.startNodeId = startNodeId;
    }

    public void connect(int idFrom, int idTo) {
        Node from = nodes.get(idFrom);
        Node to = nodes.get(idTo);
        from.connect(to, 6);
        to.connect(from, 6);
    }

    public void computeDistancesFromStart() {

        Node nodeStart = nodes.get(startNodeId);

        nodeStart.minDistance = 0;
        PriorityQueue<Node> vertexQueue = new PriorityQueue<Node>();
        vertexQueue.add(nodeStart);

        while (!vertexQueue.isEmpty()) {
            Node nodeFrom = vertexQueue.poll();

            for (Edge connection : nodeFrom.edges) {
                Node nodeTo = connection.target;

                int distanceTo = nodeFrom.minDistance + connection.weight;

                if (distanceTo < nodeTo.minDistance) {
                    vertexQueue.remove(nodeTo);

                    nodeTo.minDistance = distanceTo;
                    nodeTo.previous = nodeFrom;
                    vertexQueue.add(nodeTo);
                }
            }
        }
    }

    public int findDistanceTo(int endId) {
        int distance = nodes.get(endId).minDistance;
        return distance != Integer.MAX_VALUE ? distance : -1;
    }

    public List<Integer> findDistancesFromStart() {
        List<Integer> distances = new ArrayList<>();

        for (int nodeId = 1; nodeId <= nodes.size(); nodeId++) {
            if (nodeId == startNodeId) {
                continue;
            }

            distances.add(findDistanceTo(nodeId));
        }

        return distances;
    }
}

class Node implements Comparable<Node> {

    public int id;
    public List<Edge> edges;

    public int minDistance = Integer.MAX_VALUE;
    public Node previous;

    public Node(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public void connect(Node square, int weight) {
        edges.add(new Edge(square, weight));
    }

    @Override public String toString() {
        return String.valueOf(id);
    }

    @Override public int compareTo(Node other) {
        return Integer.compare(minDistance, other.minDistance);
    }
}

class Edge {

    public Node target;
    public int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }

}
