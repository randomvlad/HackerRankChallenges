package hackrank.algorithm.bit.flip;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Flipping Bits Challenge
 * 
 * @see https://www.hackerrank.com/challenges/flipping-bits
 */
public class Solution {
	
	public final static long MAX_32_BIT_UNSIGNED = 0xFFFF_FFFFL;

	public static void main( String[] args ) {
		
		for ( long number : readInput( System.in ) ) {
			System.out.println( ( number ^ MAX_32_BIT_UNSIGNED ) );
		}
		
	}
	
	public static long[] readInput( InputStream input ) {
		
		Scanner scanner = new Scanner( input );
		
		int length = scanner.nextInt();
		long[] numbers = new long[ length ];
		for ( int i = 0; i < length; i++ ) {
			numbers[ i ] = scanner.nextLong();
		}
		
		scanner.close();
		
		return numbers;
	}
}
