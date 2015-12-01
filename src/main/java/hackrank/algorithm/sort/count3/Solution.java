package hackrank.algorithm.sort.count3;

import java.util.Scanner;

/**
 * Counting Sort Part 3
 * 
 * @see https://www.hackerrank.com/challenges/countingsort3
 */
public class Solution {

	public static void main( String[] args ) {

		int[] counts = new int[ 100 ];

		Scanner scanner = new Scanner( System.in );

		int length = scanner.nextInt();
		for ( int i = 0; i < length; i++ ) {
			int number = scanner.nextInt();
			counts[ number ]++;
			
			scanner.next();
		}

		scanner.close();

		int total = 0;
		for ( int number = 0; number < counts.length; number++ ) {
			total += counts[ number ];
			System.out.print( total + " " );
		}
	}

}
