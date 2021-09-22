package hackrank.algorithm.graph.kruskalmst;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Kruskal (MST): Really Special Subtree
 *
 * @see https://www.hackerrank.com/challenges/kruskalmstrsub
 */
public class Solution {

    public static void main(String[] args) {
        Graph graph = readInput(System.in);
        System.out.println(graph.findKruskalMinSpanWeight());
    }

    private static Graph readInput(InputStream input) {
        Scanner scanner = new Scanner(input);

        int numberNodes = scanner.nextInt();
        int numberEdges = scanner.nextInt();

        int[][] edges = new int[numberEdges][];
        for (int e = 0; e < numberEdges; e++) {
            edges[e] = new int[] { scanner.nextInt(), scanner.nextInt(), scanner.nextInt() };
        }

        scanner.close();

        return new Graph(numberNodes, edges);
    }
}

class Graph {

    public Map<Integer, Node> nodes;
    public List<Edge> edges;

    public Graph(int numberNodes, int[][] edges) {
        this.nodes = new HashMap<>(numberNodes, 1.0f);
        this.edges = new ArrayList<>(edges.length);

        for (int nodeId = 1; nodeId <= numberNodes; nodeId++) {
            nodes.put(nodeId, new Node(nodeId));
        }

        for (int[] edge : edges) {
            connect(edge[0], edge[1], edge[2]);
        }
    }

    public void connect(int idFrom, int idTo, int weight) {
        Node from = nodes.get(idFrom);
        Node to = nodes.get(idTo);
        edges.add(new Edge(from, to, weight));
    }

    public int findKruskalMinSpanWeight() {

        Collections.sort(edges);

        int totalEdgeWeight = 0;
        UnionFind unionFind = new UnionFind();

        for (Edge edge : edges) {

            if (!unionFind.isConnected(edge.from, edge.to)) {
                totalEdgeWeight += edge.weight;
                unionFind.union(edge.from, edge.to);
            }
        }

        return totalEdgeWeight;
    }
}

class Node {

    public int id;
    public Node unionLead;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}

class Edge implements Comparable<Edge> {

    public Node from;
    public Node to;
    public int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {

        int diff = Integer.compare(weight, other.weight);
        if (diff == 0) {
            return Integer.compare(from.id + to.id, other.from.id + other.to.id);
        } else {
            return diff;
        }
    }

    @Override
    public String toString() {
        return "N(" + to.id + ") --" + weight + "-- N(" + from.id + ")";
    }

}

class UnionFind {

    private Map<Integer, List<Node>> leads;

    public UnionFind() {
        this.leads = new HashMap<>();
    }

    public boolean isConnected(Node from, Node to) {
        return from.unionLead != null && from.unionLead == to.unionLead;
    }

    public void union(Node from, Node to) {

        if (isConnected(from, to)) {
            return;
        }

        if (from.unionLead == null) {
            initLead(from);
        }

        if (to.unionLead == null) {
            initLead(to);
        }

        if (getSetSize(from) >= getSetSize(to)) {
            setNewLead(from.unionLead, to);
        } else {
            setNewLead(to.unionLead, from);
        }
    }

    private void initLead(Node node) {
        node.unionLead = node;
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        leads.put(node.id, nodes);
    }

    private int getSetSize(Node node) {
        return leads.get(node.unionLead.id).size();
    }

    private void setNewLead(Node lead, Node follower) {

        Node prevLead = follower.unionLead;
        List<Node> prevFollowers = leads.get(prevLead.id);
        leads.remove(prevLead.id);

        for (Node prevFollower : prevFollowers) {
            prevFollower.unionLead = lead;
            leads.get(lead.id).add(prevFollower);
        }
    }

}
