package hackrank.algorithm.implement.factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Extra Long Factorials
 * 
 * @see https://www.hackerrank.com/challenges/extra-long-factorials
 */
public class Solution {

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );
		int number = scanner.nextInt();
		scanner.close();
		
		BigInteger total = BigInteger.valueOf( number );

		for ( int i = number - 1; i > 1; i-- ) {
			total = total.multiply( BigInteger.valueOf( i ) );
		}
		
		System.out.println( total );
	}

}
