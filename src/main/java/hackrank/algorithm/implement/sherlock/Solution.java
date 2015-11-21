package hackrank.algorithm.implement.sherlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sherlock and The Beast
 * 
 * @see https://www.hackerrank.com/challenges/sherlock-and-the-beast
 */
public class Solution {

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );
		
		int testCases = scanner.nextInt();
		
		List<Integer> numbers = new ArrayList<>( testCases );
		for( int i = 0; i < testCases; i++ ) {
			numbers.add(  scanner.nextInt() );
		}
		
		scanner.close();
		
		for( Integer number : numbers ) {
			System.out.println( findDecentNumber( number ) );
		}
	}

	private static String findDecentNumber( int numberDigits ) {
		String value = "-1";

		switch ( numberDigits % 3 ) {

		case 0:
			value = repeat( "555", numberDigits / 3 );
			break;
		case 1:
			if ( numberDigits - 10 >= 0 ) {
				value = repeat( "555", ((numberDigits - 10) / 3) ) + "33333" + "33333";
			}
			break;
		case 2:
			if ( numberDigits - 3 >= 0 ) {
				value = repeat( "555", ((numberDigits - 3) / 3) ) + "33333";
			}
			break;
		}

		return value;
	}

	private static String repeat( String value, int times ) {
		StringBuilder sb = new StringBuilder();

		for ( int i = 0; i < times; i++ ) {
			sb.append( value );
		}

		return sb.toString();
	}

}