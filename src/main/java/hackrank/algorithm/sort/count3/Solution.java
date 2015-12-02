package hackrank.algorithm.sort.count3;

import java.util.Scanner;

/**
 * Counting Sort Part 3
 * 
 * @see https://www.hackerrank.com/challenges/countingsort3
 */
public class Solution {
	
	public static final int NUMBERS_COUNT_RANGE = 100; // exclusive

	public static void main( String[] args ) {

		int[] numbers = readInputNumbers();
		
		int[] positions = calcPositions( numbers );

		System.out.println( toString( positions ) );
	}
	
	private static int[] calcPositions( int[] numbers ) {

		int[] positions = new int[ NUMBERS_COUNT_RANGE ];
		for ( int i = 0; i < numbers.length; i++ ) {
			int number = numbers[ i ];
			positions[ number ]++;
		}

		for ( int i = 1; i < positions.length; i++ ) {
			positions[ i ] += positions[ i - 1 ];
		}

		return positions;
	}
	
	private static String toString( int[] values ) {

		StringBuilder sb = new StringBuilder();
		for ( int value : values ) {
			sb.append( value + " " );
		}

		return sb.toString();
	}
	
	private static int[] readInputNumbers() {
		
		Scanner scanner = new Scanner( System.in );

		int length = scanner.nextInt();
		int[] numbers = new int[ length ];
		for ( int i = 0; i < length; i++ ) {
			numbers[ i ] = scanner.nextInt();			
			scanner.next();
		}

		scanner.close();
		
		return numbers;
	}

}
