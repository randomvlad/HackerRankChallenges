package hackrank.algorithm.sort.quick;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Quicksort Challenge
 * 
 * @see https://www.hackerrank.com/challenges/quicksort2
 */
public class Solution {
	
	public static void main( String[] args ) {
		sort( readInput() );
	}
	
	private static void sort( int[] array ) {
		sort( array, 0, array.length );
	}
	
	private static void sort( int[] array, int start, int end ) {
		if( end - start <= 1 ) {
			return;
		}
		
		int pivotIndex = pivot( array, start, end );
		
		sort( array, start, pivotIndex );
		sort( array, pivotIndex + 1, end );
		
		System.out.println( toString( array, start, end ) );
	}
	
	private static int pivot( int[] array, int start, int end ) {
		int pivot = array[ start ];
		
		int maxSize = end - start - 1;
		List<Integer> left = new ArrayList<>( maxSize );
		List<Integer> right = new ArrayList<>( maxSize );
		
		for ( int i = start + 1; i < end; i++ ) {
			int number = array[ i ];
			
			if ( number < pivot ) {
				left.add( number );
			} else {
				right.add( number );
			}
		}
		
		set( array, left, start );
		
		int pivotIndex = start + left.size();
		array[ pivotIndex ] = pivot;
		
		set( array, right, pivotIndex + 1 );
		
		return pivotIndex;
	}
	
	private static void set( int[] array, List<Integer> newValues, int start ) {
		for ( int value : newValues ) {
			array[ start ] = value;
			start++;
		}
	}
	
	private static int[] readInput() {
		Scanner scanner = new Scanner( System.in );
		
		int length = scanner.nextInt();
		int[] array = new int[ length ];
		for ( int i = 0; i < length; i++ ) {
			array[ i ] = scanner.nextInt();
		}
		
		scanner.close();
		
		return array;
	}
	
	private static String toString( int[] array, int start, int end ) {
		StringBuilder sb = new StringBuilder();
		for ( int i = start; i < end; i++ ) {
			sb.append( array[ i ] + " "  );
		}
		return sb.toString();
	}

}