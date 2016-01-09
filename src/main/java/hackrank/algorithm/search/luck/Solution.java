package hackrank.algorithm.search.luck;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Count Luck Challenge
 * 
 * @see https://www.hackerrank.com/challenges/count-luck
 */
public class Solution {
	
	public static void main( String[] args ) {
		
		for ( Grid grid : readInput( System.in ) ) {
			System.out.println( ( grid.countOptimalChoices() == grid.numberChoices ) ? "Impressed" : "Oops!" );
		}
	}
	
	public static List<Grid> readInput( InputStream stream ) {
		Scanner scanner = new Scanner( stream );
		
		int numberTests = scanner.nextInt();
		List<Grid> grids = new ArrayList<>();
		
		for ( int t = 0; t < numberTests; t++ ) {
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			
			char[][] data = new char[ rows ][ columns ];
			for ( int r = 0; r < rows; r++ ) {
				
				String row = scanner.next();
				for ( int c = 0; c < row.length(); c++ ) {
					data[ r ][ c ] = row.charAt( c );
				}
			}	
			
			int numberChoices = scanner.nextInt();
			
			grids.add( new Grid( data, numberChoices ) );
		}
		
		scanner.close();

		return grids;
	}

}

class Grid {
	
	enum CellType {
		HERMIONE( 'M' ),
		EXIT( '*' ),
		EMPTY( '.' ),
		TREE( 'X' );
		
		private char value;
		
		CellType( char value ) {
			this.value = value;
		}
		
		char getValue() {
			return value;
		}
	} 
	
	char[][] data;
	int numberChoices;
	int startRow;
	int startColumn;

	Grid( char[][] data, int numberLuckyChoices ) {
		this.data = data;
		this.numberChoices = numberLuckyChoices;
		
		for ( int r = 0; r < getNumberRows(); r++ ) {
			for ( int c = 0; c < getNumberColumns(); c++ ) {
				if ( data[ r ][ c ] == CellType.HERMIONE.getValue() ) {
					startRow = r;
					startColumn = c;
				}
			}
		}
		
	}
	
	public int countOptimalChoices() {
		Set<String> visisted = new HashSet<>();
		return depthFirstSearch( startRow, startColumn, visisted, 0 );
	}
	
	private int depthFirstSearch( int row, int column, Set<String> visited, int optionsFound ) {
				
		char value = data[ row ][ column ];
		visited.add( row + "-" + column );
		
		if ( value == CellType.EXIT.getValue() ) {
			return optionsFound;
		}
		
		List<Integer[]> adjacent = adjacentAvailable( row, column, visited );
		if ( adjacent.isEmpty() ) {
			return -1;
		}
		
		if ( adjacent.size() > 1 ) {
			optionsFound++;
		}
		
		for ( Integer[] cell : adjacent ) {
			int found = depthFirstSearch( cell[ 0 ], cell[ 1 ], visited, optionsFound );
			if ( found != -1 ) {
				return found;
			}
		}
		
		return -1;
	}
	
	private List<Integer[]> adjacentAvailable( int row, int column, Set<String> visited ) {
		
		int[][] directions = {
				{ row - 1, column },
				{ row, column - 1 },
				{ row, column + 1 },
				{ row + 1, column }
		};

		List<Integer[]> available = new ArrayList<>();
		for ( int[] cell : directions ) {
			int r = cell[ 0 ];
			int c = cell[ 1 ];
			if ( isAvailable( r, c ) && ! visited.contains( r + "-" + c ) ) {
				available.add( new Integer[] { r, c } );
			}
		}
		
		return available;
	}

	public boolean isAvailable( int row, int column ) {
		if ( row < 0 || row >= getNumberRows() ) {
			return false;
		}

		if ( column < 0 || column >= getNumberColumns() ) {
			return false;
		}
		
		char value = data[ row ][ column ];
		
		return value == CellType.EMPTY.getValue() || value == CellType.EXIT.getValue();
	}

	public int getNumberRows() {
		return data.length;
	}

	public int getNumberColumns() {
		return data[ 0 ].length;
	}
	
}
