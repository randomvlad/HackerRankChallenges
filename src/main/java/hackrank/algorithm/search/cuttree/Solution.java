package hackrank.algorithm.search.cuttree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Cut the Tree Challenge
 *
 * @see https://www.hackerrank.com/challenges/cut-the-tree
 */
public class Solution {

    public final static int ROOT_NODE_ID = 1;

    public static void main(String[] args) {

        Graph graph = readInput();

        graph.orient(ROOT_NODE_ID);

        int minDiff = Integer.MAX_VALUE;
        for (Integer[] edge : graph.edges) {
            int from = edge[0];
            int to = edge[1];

            int diff = graph.cutDiff(from, to);
            if (diff < minDiff) {
                minDiff = diff;
            }
            // System.out.println( "Remove (" + from + "," + to + ") => diff = " + diff );
        }

        System.out.println(minDiff);
    }

    private static Graph readInput() {
        Scanner scanner = new Scanner(System.in);

        Graph graph = new Graph(scanner.nextInt());

        for (int nodeId = 1; nodeId <= graph.size; nodeId++) {
            graph.add(new Node(nodeId, scanner.nextInt()));
        }

        for (int edge = 0; edge < graph.size - 1; edge++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        scanner.close();

        return graph;
    }

    static class Graph {

        public int total;
        public int size;
        public Map<Integer, Node> lookup;
        public List<Integer[]> edges;

        public Graph(int size) {
            this.size = size;
            this.lookup = new HashMap<>(size, 1.0f);
            this.edges = new ArrayList<>(size - 1);
        }

        public void add(Node node) {
            lookup.put(node.id, node);
            total += node.value;
        }

        public void addEdge(int fromId, int toId) {
            Node nodeFrom = lookup.get(fromId);
            Node nodeTo = lookup.get(toId);

            nodeFrom.connect(nodeTo);
            edges.add(new Integer[] { fromId, toId });
        }

        public int cutDiff(int firstId, int secondId) {
            Node first = lookup.get(firstId);
            Node second = lookup.get(secondId);

            Node lower = first.level > second.level ? first : second;
            int aboveCutTotal = this.total - lower.total;
            return Math.abs(aboveCutTotal - lower.total);
        }

        public void orient(int rootId) {
            Node root = lookup.get(rootId);
            root.parent = null;
            root.level = 0;

            Set<Integer> visited = new HashSet<>(size);
            Deque<Node> nodes = new ArrayDeque<>();
            nodes.push(root);

            while (!nodes.isEmpty()) {
                Node current = nodes.pop();

                visited.add(current.id);

                for (Node child : current.nodes) {
                    if (!visited.contains(child.id)) {
                        child.parent = current;
                        child.level = current.level + 1;
                        nodes.push(child);
                    }
                }
            }

            calcTotals(root);
        }

        private void calcTotals(Node root) {
            Set<Integer> visited = new HashSet<>();

            Node node = root;
            while (node != null) {
                while (node.hasChildren()) {
                    Node nonVisitedChild = findNonVisitedChild(node, visited);

                    if (nonVisitedChild == null) {
                        break; // arrived at leaf node or all node children have been visited
                    } else {
                        node = nonVisitedChild; // continue traversing further down the graph
                    }
                }

                node.total = node.calcTotal();
                visited.add(node.id);
                node = node.parent;
            }
        }

        private Node findNonVisitedChild(Node node, Set<Integer> visited) {
            for (Node child : node.getChildren()) {
                if (!visited.contains(child.id)) {
                    return child;
                }
            }
            return null;
        }
    }

    static class Node {

        public int id;
        public int value;
        public int total;
        public int level;

        public Node parent;
        public List<Node> nodes;

        public Node(int id, int value) {
            this.id = id;
            this.value = value;
            this.nodes = new ArrayList<>();
        }

        public void connect(Node node) {

            if (!isConnected(node)) {
                this.nodes.add(node);
            }

            if (!node.isConnected(this)) {
                node.nodes.add(this);
            }
        }

        public boolean isConnected(Node node) {

            for (Node existing : nodes) {
                if (existing.id == node.id) {
                    return true;
                }
            }

            return false;
        }

        public List<Node> getChildren() {
            if (parent == null) {
                return nodes;
            }

            List<Node> children = new ArrayList<>();
            for (Node child : nodes) {
                if (child.id != parent.id) {
                    children.add(child);
                }
            }

            return children;
        }

        public boolean hasChildren() {
            return !nodes.isEmpty();
        }

        public int calcTotal() {
            int childrenTotal = getChildren().stream().mapToInt(n -> n.total).sum();
            return value + childrenTotal;
        }

        @Override public String toString() {
            return "Node (" + id + "): value = " + value + ", total = " + total;
        }
    }
}
