package hackrank.algorithm.bit.ninja;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Xoring Ninja
 * 
 * @see https://www.hackerrank.com/challenges/xoring-ninja
 */
public class Solution {

	public static void main( String[] args ) {
		// TODO: deal with overflow?
		for ( Integer[] numbers : readInput( System.in ) ) {
			System.out.println( (xorSum( numbers ) % 1_000_000_007) );
		}
	}

	public static long xorSum( Integer[] numbers ) {

		long sum = 0;

		for ( int i = 0; i < numbers.length; i++ ) {
			sum += numbers[ i ];
		}

		for ( int size = 2; size <= numbers.length; size++ ) {
			for ( int i = 0; i <= numbers.length - size; i++ ) {
				int xorTotal = 0;
				for ( int j = i; j < i + size; j++ ) {
					xorTotal ^= numbers[ j ];
				}

				System.out.println( xorTotal );

				sum += xorTotal;
			}
		}

		int lead = 0;
		for ( int i = lead + 1; i < numbers.length; i++ ) {
			// 1 lead, 3 available elements, set size 2
		}

		return sum;
	}

	public static void permutations( Integer[] numbers, int lead, int size ) {

		int available = numbers.length - (lead + 1);

		int permuts = available - size + 1;

		// pick x elements (x=size) from numbers after index lead

		for ( int i = 0; i < available; i++ ) {

		}

	}

	public static String extract( Integer[] numbers, int i, int size ) {

		StringBuilder sb = new StringBuilder();
		for ( int j = i; j < i + size; j++ ) {
			sb.append( numbers[ j ] + " " );
		}

		return "[" + sb.toString().trim() + "]";
	}

	public static List<Integer[]> readInput( InputStream input ) {

		Scanner scanner = new Scanner( input );

		int testCases = scanner.nextInt();
		List<Integer[]> data = new ArrayList<>( testCases );

		for ( int i = 0; i < testCases; i++ ) {

			int length = scanner.nextInt();
			Integer[] numbers = new Integer[ length ];

			for ( int j = 0; j < length; j++ ) {
				numbers[ j ] = scanner.nextInt();
			}

			data.add( numbers );
		}

		scanner.close();

		return data;
	}
}