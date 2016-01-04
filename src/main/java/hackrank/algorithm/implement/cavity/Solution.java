package hackrank.algorithm.implement.cavity;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Cavity Map Challenge
 */
public class Solution {

	public static void main( String[] args ) {

		Grid grid = readInput( System.in );

		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0; i < grid.size(); i++ ) {
			for ( int j = 0; j < grid.size(); j++ ) {
				if ( grid.isCavity( i, j ) ) {
					sb.append( "X" );
				} else {
					sb.append( grid.get( i, j ) );
				}
			}
			
			sb.append( System.lineSeparator() );
		}
		
		System.out.println( sb.toString() );
	}
	
	public static Grid readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int size = scanner.nextInt();
		
		int[][] data = new int[ size ][ size ];
		for ( int i = 0; i < size; i++ ) {
			
			String row = scanner.next();
			for ( int j = 0; j < size; j++ ) {
				data[ i ][ j ] = Integer.valueOf( row.charAt( j ) + "" );
			}
		}
		
		scanner.close();
		
		return new Grid( data );
	}

}


class Grid {
	
	int[][] data;
	
	Grid( int[][] data ) {
		this.data = data;
	}
	
	public int get( int i, int j ) {
		return data[ i ][ j ];
	}
	
	public boolean isCavity( int i, int j ) {
		
		int minIndex = 0;
		int maxIndex = size() - 1;
		
		if ( i == minIndex || i == maxIndex || j == minIndex || j == maxIndex ) {
			return false;
		}
		
		int[][] adjacent = {
				{ i - 1, j }, 
				{ i, j - 1 },
				{ i, j + 1 },
				{ i + 1, j }
		};
		
		for ( int[] cell : adjacent ) {
			
			int row = cell[ 0 ];
			int column = cell[ 1 ];
			
			if ( data[ row ][ column ] >= data[ i ][ j ] ) {
				return false;
			}
		}
		
		return true;
	}
	
	public int size() {
		return data.length;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0; i < size(); i++ ) {
			for ( int j = 0; j < size(); j++ ) {
				sb.append( data[ i ][ j ] );
			}
			
			sb.append( System.lineSeparator() );
		}
		
		return sb.toString();
	}
	
}