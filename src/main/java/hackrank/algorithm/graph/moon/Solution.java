package hackrank.algorithm.graph.moon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Journey to the Moon
 *
 * @see https://www.hackerrank.com/challenges/journey-to-the-moon
 * @see http://algs4.cs.princeton.edu/15uf/ (nice chapter about union find)
 */
public class Solution {

    public static void main(String[] args) {
        UnionFind unionFind = readInput(System.in);
        System.out.println(countPermutations(unionFind.getSetSizes()));
    }

    public static long countPermutations(List<Integer> setSizes) {

        List<Integer> optimizedSizes = new ArrayList<>();

        // Optimization: count number of sets of size 1 to simplify later multiplication
        long singleNodes = 0;
        for (int size : setSizes) {
            if (size == 1) {
                singleNodes++;
            } else {
                optimizedSizes.add(size);
            }
        }

        if (singleNodes > 0) {
            optimizedSizes.add((int) singleNodes);
        }

        long permutations = 0;

        for (int i = 0; i < optimizedSizes.size() - 1; i++) {
            for (int j = i + 1; j < optimizedSizes.size(); j++) {
                permutations += optimizedSizes.get(i) * optimizedSizes.get(j);
            }
        }

        if (singleNodes > 0) {
            permutations += singleNodes * (singleNodes - 1) / 2;
        }

        return permutations;
    }

    private static UnionFind readInput(InputStream input) {
        Scanner scanner = new Scanner(input);

        int numberNodes = scanner.nextInt();
        int numberEdges = scanner.nextInt();

        UnionFind unionFind = new UnionFind(numberNodes);

        for (int e = 0; e < numberEdges; e++) {
            unionFind.union(scanner.nextInt(), scanner.nextInt());
        }

        scanner.close();

        return unionFind;
    }
}

class UnionFind {

    private int[] nodeLeads;

    public UnionFind(int numberNodes) {
        nodeLeads = new int[numberNodes];
        for (int i = 0; i < numberNodes; i++) {
            nodeLeads[i] = i;
        }
    }

    public List<Integer> getSetSizes() {

        Map<Integer, Integer> sizes = new HashMap<>();

        for (int nodeId = 0; nodeId < nodeLeads.length; nodeId++) {
            int nodeLeadId = find(nodeId);

            if (!sizes.containsKey(nodeLeadId)) {
                sizes.put(nodeLeadId, 1);
            } else {
                int size = sizes.get(nodeLeadId);
                sizes.put(nodeLeadId, size + 1);
            }
        }

        return new ArrayList<>(sizes.values());
    }

    public int find(int nodeId) {

        int nodeLeadId = nodeId;
        while (nodeLeadId != nodeLeads[nodeLeadId]) {
            nodeLeadId = nodeLeads[nodeLeadId];
        }

        while (nodeId != nodeLeadId) {
            int nextNodeId = nodeLeads[nodeId];
            nodeLeads[nodeId] = nodeLeadId; // compress path: re-point to new lead id
            nodeId = nextNodeId;
        }

        return nodeLeadId;
    }

    public void union(int firstId, int secondId) {
        int firstLeadId = find(firstId);
        int secondLeadId = find(secondId);
        if (firstLeadId != secondLeadId) {
            nodeLeads[firstLeadId] = secondLeadId;
        }
    }

}
