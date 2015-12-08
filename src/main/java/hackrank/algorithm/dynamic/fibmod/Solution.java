package hackrank.algorithm.dynamic.fibmod;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Fibonacci Modified Challenge
 * 
 * @see https://www.hackerrank.com/challenges/fibonacci-modified
 */
public class Solution {

	public static void main( String[] args ) {
		
		Scanner scanner = new Scanner( System.in );
		
		int firstTerm = scanner.nextInt();
		int secondTerm = scanner.nextInt();
		int term = scanner.nextInt();
		
		scanner.close();
		
		BigInteger prevPrev = BigInteger.valueOf( firstTerm );
		BigInteger prev = BigInteger.valueOf( secondTerm );
		BigInteger current = null;
		
		for ( int i = 3; i <= term; i++ ) {
			current = prev.multiply( prev ).add( prevPrev );
			
			prevPrev = prev;
			prev = current;
		}
		
		System.out.println( current.toString() );
	}

}
