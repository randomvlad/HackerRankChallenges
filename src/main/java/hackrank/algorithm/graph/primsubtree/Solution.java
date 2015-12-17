package hackrank.algorithm.graph.primsubtree;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * Prim's (MST): Special Subtree
 * 
 * @see https://www.hackerrank.com/challenges/primsmstsub
 */
public class Solution {

	public static void main( String[] args ) {
		Graph graph = readInput( System.in );
		System.out.println( graph.findPrimMinSpanWeight() );
	}
	
	private static Graph readInput( InputStream input ) {
		Scanner scanner = new Scanner( input );

		int numberNodes = scanner.nextInt();
		int numberEdges = scanner.nextInt();

		int[][] edges = new int[ numberEdges ][];
		for ( int e = 0; e < numberEdges; e++ ) {
			edges[ e ] = new int[] { scanner.nextInt(), scanner.nextInt(), scanner.nextInt() };
		}

		int startNodeId = scanner.nextInt();
		
		scanner.close();
		
		return new Graph( numberNodes, edges, startNodeId );
	}
}

class Graph {

	public Map<Integer, Node> nodes;
	public int startNodeId;

	public Graph( int numberNodes, int[][] edges, int startNodeId ) {
		this.nodes = new HashMap<>( numberNodes, 1.0f );

		for ( int nodeId = 1; nodeId <= numberNodes; nodeId++ ) {
			nodes.put( nodeId, new Node( nodeId ) );
		}

		for ( int[] edge : edges ) {
			connect( edge[ 0 ], edge[ 1 ], edge[ 2 ] );
		}

		this.startNodeId = startNodeId;
	}

	public void connect( int idFrom, int idTo, int weight ) {
		Node from = nodes.get( idFrom );
		Node to = nodes.get( idTo );
		from.connect( to, weight );
		to.connect( from, weight );
	}
	
	public int findPrimMinSpanWeight() {
		
		Node start = nodes.get( startNodeId );
		
		Set<Integer> visited = new HashSet<>( nodes.size() );		
		visited.add( start.id );
				
		PriorityQueue<Edge> edgesQueue = new PriorityQueue<Edge>( start.edges );
		int totalEdgeWeight = 0;
		
		while ( !edgesQueue.isEmpty() ) {
			Edge edge = edgesQueue.poll();
			if ( visited.contains( edge.target.id ) ) {
				continue;
			}
			
			totalEdgeWeight += edge.weight;
			visited.add( edge.target.id );
			
			for ( Edge nextEdge : edge.target.edges ) {
				if ( ! visited.contains( nextEdge.target.id ) ) {
					edgesQueue.add( nextEdge );
				}
			}
		}
		
		return totalEdgeWeight;
	}
}

class Node {

	public int id;
	public List<Edge> edges;

	public Node( int id ) {
		this.id = id;
		this.edges = new ArrayList<>();
	}

	public void connect( Node square, int weight ) {
		edges.add( new Edge( square, weight ) );
	}

	@Override
	public String toString() {
		return String.valueOf( id );
	}
	
}

class Edge implements Comparable<Edge> {

	public Node target;
	public int weight;

	public Edge( Node target, int weight ) {
		this.target = target;
		this.weight = weight;
	}
	
	@Override
	public int compareTo( Edge other ) {
		return Integer.compare( weight, other.weight );
	}
	
	@Override
	public String toString() {
		return "-" + weight + "-> Node(" + target.id + ")";
	}

}