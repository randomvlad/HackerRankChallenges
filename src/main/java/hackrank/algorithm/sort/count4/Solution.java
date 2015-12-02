package hackrank.algorithm.sort.count4;

import java.util.Scanner;

/**
 * Counting Sort Part 4 - Full Sort
 * 
 * @see https://www.hackerrank.com/challenges/countingsort4
 */
public class Solution {

	public static final int NUMBERS_COUNT_RANGE = 100; // exclusive

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );

		int length = scanner.nextInt();

		int[] numbers = new int[ length ];
		String[] values = new String[ length ];
		for ( int i = 0; i < length; i++ ) {
			numbers[ i ] = scanner.nextInt();
			values[ i ] = scanner.next();
		}

		scanner.close();

		int[] positions = calcPositions( numbers );

		String[] sorted = new String[ values.length ];
		for ( int i = values.length - 1; i >= values.length / 2; i-- ) {
			String value = values[ i ];
			int number = numbers[ i ];

			positions[ number ]--;
			int sortedIndex = positions[ number ];

			sorted[ sortedIndex ] = value;
		}

		System.out.println( toString( sorted ) );
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

	private static String toString( String[] values ) {

		StringBuilder sb = new StringBuilder();
		for ( String value : values ) {
			sb.append( (value != null ? value : "-") + " " );
		}

		return sb.toString();
	}

}
