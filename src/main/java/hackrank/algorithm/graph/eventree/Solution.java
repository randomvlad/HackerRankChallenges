package hackrank.algorithm.graph.eventree;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Even Tree
 *
 * @see https://www.hackerrank.com/challenges/even-tree
 */
public class Solution {

    public final static int ROOT_NODE_ID = 1;

    public static void main(String[] args) {
        Graph graph = readInput(System.in);
        graph.orient(ROOT_NODE_ID);
        System.out.println(graph.decomposeEvenForest());
    }

    private static Graph readInput(InputStream input) {
        Scanner scanner = new Scanner(input);

        int numberNodes = scanner.nextInt();
        int numberEdges = scanner.nextInt();

        int[][] edges = new int[numberEdges][];
        for (int e = 0; e < numberEdges; e++) {
            edges[e] = new int[] { scanner.nextInt(), scanner.nextInt() };
        }

        scanner.close();

        return new Graph(numberNodes, edges);
    }
}

class Graph {

    public Node root;
    public Map<Integer, Node> nodes;
    private int edgesRemoved;

    public Graph(int numberNodes, int[][] edges) {
        this.nodes = new HashMap<>(numberNodes, 1.0f);

        for (int nodeId = 1; nodeId <= numberNodes; nodeId++) {
            nodes.put(nodeId, new Node(nodeId));
        }

        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
    }

    public void connect(int idFrom, int idTo) {
        Node from = nodes.get(idFrom);
        Node to = nodes.get(idTo);
        from.connect(to);
        to.connect(from);
    }

    public void orient(int rootId) {
        root = nodes.get(rootId);
        root.parent = null;

        Set<Integer> visited = new HashSet<>(nodes.size());
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            Node current = nodes.pop();

            visited.add(current.id);

            for (Edge edge : current.edges) {
                Node child = edge.target;
                if (!visited.contains(child.id)) {
                    child.parent = current;
                    nodes.push(child);
                }
            }
        }
    }

    public int decomposeEvenForest() {
        edgesRemoved = 0;
        decompose(root);
        return edgesRemoved;
    }

    private int decompose(Node node) {

        int count = 1;
        for (Node child : node.getChildren()) {
            count += decompose(child);
        }

        if (count % 2 == 0 && node.parent != null) {
            edgesRemoved++;
            return 0;
        } else {
            return count;
        }
    }
}

class Node {

    public int id;
    public Node parent;
    public List<Edge> edges;

    public Node(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public void connect(Node square) {
        edges.add(new Edge(square));
    }

    public List<Node> getChildren() {
        if (parent == null) {
            return edges.stream().map(e -> e.target).collect(Collectors.toList());
        }

        List<Node> children = new ArrayList<>();
        for (Edge edge : edges) {
            Node child = edge.target;
            if (child.id != parent.id) {
                children.add(child);
            }
        }

        return children;
    }

    @Override public String toString() {
        return String.valueOf(id);
    }

}

class Edge {

    public Node target;

    public Edge(Node target) {
        this.target = target;
    }

    @Override public String toString() {
        return "-> N(" + target.id + ")";
    }

}
