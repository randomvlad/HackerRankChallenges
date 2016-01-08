package hackrank.algorithm.search.connected;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Connected Cell in a Grid Challenge
 * 
 * @see https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 */
public class Solution {

	public static void main( String[] args ) {

		Grid grid = readInput( System.in );
		System.out.println( grid.findMaxConnected() );
	}

	public static Grid readInput( InputStream stream ) {
		Scanner scanner = new Scanner( stream );

		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		
		int[][] data = new int[ rows ][ columns ];
		for ( int r = 0; r < rows; r++ ) {
			for ( int c = 0; c < columns; c++ ) {
				data[ r ][ c ] = scanner.nextInt();
			}
		}

		scanner.close();

		return new Grid( data );
	}

}

class Grid {

	private int[][] data;

	Grid( int[][] data ) {
		this.data = data;
	}
	
	public int findMaxConnected() {
		
		Set<String> visisted = new HashSet<>();
		List<Integer> sizes = new ArrayList<>();
		for ( int r = 0; r < getNumberRows(); r++ ) {
			for ( int c = 0; c < getNumberColumns(); c++ ) {
				sizes.add( depthFirstSearch( r, c, visisted ) );
			}
		}
		
		return sizes.stream().max( Integer::compareTo ).get();
	}
	
	private int depthFirstSearch( int row, int column, Set<String> visited ) {
		
		if ( ! hasValue( row, column ) || visited.contains( (row + "-" + column) ) ) {
			return 0;
		}
		
		int value = 1;
		visited.add( row + "-" + column );
		
		for ( Integer[] cell : adjacent( row, column ) ) {
			value += depthFirstSearch( cell[ 0 ], cell[ 1 ], visited );
		}
		
		return value;
	}
	
	private List<Integer[]> adjacent( int row, int column ) {
		
		int[][] directions = {
				{ row - 1, column - 1 },
				{ row - 1, column },
				{ row - 1, column + 1 }, 
				{ row, column - 1 },
				{ row, column + 1 },
				{ row + 1, column - 1 }, 
				{ row + 1, column },
				{ row + 1, column + 1 }
		};

		List<Integer[]> adjacent = new ArrayList<>();
		for ( int[] cell : directions ) {
			if ( hasValue( cell[ 0 ], cell[ 1 ] ) ) {
				adjacent.add( new Integer[] { cell[ 0 ], cell[ 1 ] } );
			}
		}
		
		return adjacent;
	}

	public boolean hasValue( int row, int column ) {
		if ( row < 0 || row >= getNumberRows() ) {
			return false;
		}

		if ( column < 0 || column >= getNumberColumns() ) {
			return false;
		}

		return data[ row ][ column ] == 1;
	}

	public int getNumberRows() {
		return data.length;
	}

	public int getNumberColumns() {
		return data[ 0 ].length;
	}
}