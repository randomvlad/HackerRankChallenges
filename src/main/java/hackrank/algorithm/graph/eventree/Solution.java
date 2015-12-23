package hackrank.algorithm.graph.eventree;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Even Tree
 * 
 * @see https://www.hackerrank.com/challenges/even-tree
 */
public class Solution {

	public static void main( String[] args ) {
		Graph graph = readInput( System.in );
		System.out.println( graph.countRemovedEdges() );
	}
	
	private static Graph readInput( InputStream input ) {
		Scanner scanner = new Scanner( input );

		int numberNodes = scanner.nextInt();
		int numberEdges = scanner.nextInt();

		int[][] edges = new int[ numberEdges ][];
		for ( int e = 0; e < numberEdges; e++ ) {
			edges[ e ] = new int[] { scanner.nextInt(), scanner.nextInt() };
		}
		
		scanner.close();
		
		return new Graph( numberNodes, edges );
	}
}

class Graph {

	public Map<Integer, Node> nodes;

	public Graph( int numberNodes, int[][] edges ) {
		this.nodes = new HashMap<>( numberNodes, 1.0f );

		for ( int nodeId = 1; nodeId <= numberNodes; nodeId++ ) {
			nodes.put( nodeId, new Node( nodeId ) );
		}

		for ( int[] edge : edges ) {
			connect( edge[ 0 ], edge[ 1 ] );
		}
	}

	public void connect( int idFrom, int idTo ) {
		
		// TODO: single or double connection of edges?
		
		Node from = nodes.get( idFrom );
		Node to = nodes.get( idTo );
		from.connect( to );
		to.connect( from );
	}
	
	public int countRemovedEdges() {
		return 0;
	}
	
}

class Node {

	public int id;
	public List<Edge> edges;

	public Node( int id ) {
		this.id = id;
		this.edges = new ArrayList<>();
	}

	public void connect( Node square ) {
		edges.add( new Edge( square ) );
	}

	@Override
	public String toString() {
		return String.valueOf( id );
	}
	
}

class Edge {

	public Node target;

	public Edge( Node target ) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "-> N(" + target.id + ")";
	}

}