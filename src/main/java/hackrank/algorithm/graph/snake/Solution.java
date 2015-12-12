package hackrank.algorithm.graph.snake;

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
	
	public static void main( String[] args ) {
		
		// TODO: solution is not complete. fails for a unit test
		
		for ( Board board: readInput() ) {
			System.out.println( board.calculateMoves( 1, 100 ) );
		}
	}
	
	private static List<Board> readInput() {
		Scanner scanner = new Scanner( System.in );
		
		int testCases = scanner.nextInt();
		
		List<Board> boards = new ArrayList<>( testCases );
		for ( int i = 0; i < testCases; i++ ) {
		
			int numberLadders = scanner.nextInt();
			int[][] ladders = new int[ numberLadders ][];
			for ( int l = 0; l < numberLadders; l++ ) {
				ladders[ l ] = new int[] { scanner.nextInt(), scanner.nextInt() };
			}
			
			int numberSnakes = scanner.nextInt();
			int[][] snakes = new int[ numberSnakes ][];
			for ( int s = 0; s < numberSnakes; s++ ) {
				snakes[ s ] = new int[]{ scanner.nextInt(), scanner.nextInt() };
			}
			
			boards.add( Board.create( ladders, snakes ) );
		}
		
		scanner.close();
		
		return boards;
	}
}

class Board {
	
	public Map<Integer,Square> squares;
	
	public static Board create( int[][] ladders, int[][] snakes ) {
		int numberSquares = 100;
		
		Board board = new Board( numberSquares );
		
		for ( int squareId = 1; squareId <= numberSquares; squareId++ ) {
			board.add( squareId );
		}
		
		for ( int squareId = 1; squareId < numberSquares; squareId++ ) {
			board.connect( squareId, (squareId + 1), 1, Square.Type.REGULAR );
		}
		
		for ( int[] ladder : ladders ) {
			board.connect(  ladder[ 0 ], ladder[ 1 ], 0, Square.Type.LADDER );
		}
		
		for ( int[] snake : snakes ) {
			board.connect( snake[ 0 ], snake[ 1 ], 0, Square.Type.SNAKE );
		}
		
		return board;
	}
	
	private Board( int numberSquares ) {
		squares = new HashMap<>( numberSquares, 1.0f );
	}
	
	public void add( int squareId ) {
		squares.put( squareId, new Square( squareId ) );
	}
	
	public void connect( int idFrom, int idTo, int weight, Square.Type type ) {
		Square from = squares.get( idFrom );
		Square to = squares.get( idTo );
		from.connect( to, weight );
		from.type = type;
	}
	
	private void computePaths( Square squareStart ) {
		
		squareStart.minDistance = 0;
		PriorityQueue<Square> vertexQueue = new PriorityQueue<Square>();
		vertexQueue.add( squareStart );

		while ( !vertexQueue.isEmpty() ) {
			Square squareFrom = vertexQueue.poll();

			for ( Connection connection : squareFrom.connections ) {
				Square nodeTo = connection.target;
				
				int distanceTo = squareFrom.minDistance + connection.weight;
				
				if ( distanceTo < nodeTo.minDistance ) {
					vertexQueue.remove( nodeTo );

					nodeTo.minDistance = distanceTo;
					nodeTo.previous = squareFrom;
					vertexQueue.add( nodeTo );
				}
			}
		}
	}
	
	public List<Square> findPathTo( int startId, int endId ) {
		Square start = squares.get( startId );
		
		computePaths( start );
		
		Square end = squares.get( endId );
		List<Square> path = new ArrayList<Square>();
		for ( Square square = end; square != null; square = square.previous ) {
			path.add( square );
		}

		Collections.reverse( path );
		return path;
	}
	
	public int calculateMoves( int startId, int endId ) {
		
		List<Square> path = findPathTo( startId, endId );
		
		int moves = 0;
		int steps = 0;
		int consecutiveSnakes = 0;
		
		for ( int i = 0; i < path.size() - 1; i++ ) {
			Square current = path.get( i );
			Square next = path.get( i + 1 );
			
			if ( current.type == Square.Type.SNAKE ) {
				consecutiveSnakes++;
				if ( consecutiveSnakes == 6 ) {
					return -1;
				}
			} else {
				consecutiveSnakes = 0;
			}
			
			int step = next.minDistance - current.minDistance;
			if ( step == 0 ) {
				if ( steps > 0 ) {
					moves++;
				}
				steps = 0;
				continue;
			}
			
			steps += step;
					
			if ( steps > 1 && steps % 6 == 0 ) {
				steps = 0;
				moves++;
			}
		}
		
		if ( steps >= 1 ) {
			moves++;
		}
		
		return moves;
	}
}

class Square implements Comparable<Square> {
	
	enum Type {
		SNAKE,
		LADDER,
		REGULAR
	};
	
	public int id;
	public Square.Type type;
	public List<Connection> connections;
	
	public int minDistance = Integer.MAX_VALUE;
	public Square previous;
	
	public Square( int id ) {
		this.id = id;
		this.type = Type.REGULAR;
		this.connections = new ArrayList<>();
	}
	
	public void connect( Square square ) {
		connect( square, 1 );
	}
	
	public void connect( Square square, int weight ) {
		connections.add( new Connection( square, weight ) );
	}
	
	public boolean hasShortcut() {
		return connections.size() > 1;
	}
	
	@Override
	public String toString() {
		return String.valueOf( id );
	}

	@Override
	public int compareTo( Square other ) {
		return Integer.compare( minDistance, other.minDistance );
	}
}

class Connection {
	
	public Square target;
	public int weight;
	
	public Connection( Square target, int weight ) {
		this.target = target;
		this.weight = weight;
	}
	
}
