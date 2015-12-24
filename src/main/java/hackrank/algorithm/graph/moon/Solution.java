package hackrank.algorithm.graph.moon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Journey to the Moon
 * 
 * @see https://www.hackerrank.com/challenges/journey-to-the-moon
 */
public class Solution {

	public static void main( String[] args ) {
		Graph graph = readInput( System.in );
		// System.out.println( graph.countForests() );
		System.out.println( graph.countPermutations() );
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

		for ( int nodeId = 0; nodeId < numberNodes; nodeId++ ) {
			nodes.put( nodeId, new Node( nodeId ) );
		}

		for ( int[] edge : edges ) {
			connect( edge[ 0 ], edge[ 1 ] );
		}
	}

	public void connect( int idFrom, int idTo ) {
		Node from = nodes.get( idFrom );
		Node to = nodes.get( idTo );
		from.connect( to );
		to.connect( from );
	}
	
	public List<Integer> countForests() {
		
		List<Integer> counts = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		
		for ( int nodeId : nodes.keySet() ) {
			
			if ( visited.contains( nodeId ) ) {
				continue;
			}
			
			Node node = nodes.get( nodeId );
			visited.add( node.id );
			
			int count = 1;
			for ( Node descendant : node.getDescendants() ) {
				visited.add( descendant.id );
				count++;
			}
			
			counts.add( count );
		}
		
		return counts;
	}
	
	public int countPermutations() {
		List<Integer> counts = countForests();
		
		int permutations = 0;
		for ( int i = 0; i < counts.size() - 1; i++ ) {
			for ( int j = i + 1; j < counts.size(); j++ ) {
				permutations += counts.get( i ) * counts.get( j );
			}
		}
		
		return permutations;
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
	
	public List<Node> getDescendants() {
		return getDescendants( null );
	}
	
	private List<Node> getDescendants( Node parent ) {
		List<Node> descendants = new ArrayList<>();
		
		for ( Edge edge : edges ) {
			if ( parent != null && parent.id == edge.target.id ) {
				continue;
			}
			
			descendants.add( edge.target );
			
			for ( Node descendant : edge.target.getDescendants( this ) ) {
				if ( descendant.id != edge.target.id ) {
					descendants.add( descendant );
				}
			}
		}
		
		
		return descendants;
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