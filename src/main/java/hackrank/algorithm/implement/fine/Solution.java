package hackrank.algorithm.implement.fine;

import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Library Fine Challenge
 * 
 * @see https://www.hackerrank.com/challenges/library-fine
 */
public class Solution {

	public static void main( String[] args ) {
		
		Calendar[] dates = readInput( System.in );
		System.out.println( calculateFine( dates[ 0 ], dates[ 1 ] ) );
	}
	
	public static int calculateFine( Calendar returnDate, Calendar expectedDate ) {
		
		if ( returnDate.compareTo( expectedDate ) <= 0 ) {
			return 0;
		}
		
		if ( returnDate.get( Calendar.YEAR ) != expectedDate.get( Calendar.YEAR ) ) {
			return 10000;
		} else if ( returnDate.get( Calendar.MONTH ) != expectedDate.get( Calendar.MONTH ) ) {
			return 500 * ( returnDate.get( Calendar.MONTH ) - expectedDate.get( Calendar.MONTH ) );
		} else {
			return 15 * ( returnDate.get( Calendar.DAY_OF_MONTH ) - expectedDate.get( Calendar.DAY_OF_MONTH ) );
		}
	}
	
	public static Calendar[] readInput( InputStream stream  ) {
		
		Scanner scanner = new Scanner( stream );
		
		int returnDay = scanner.nextInt();
		int returnMonth = scanner.nextInt();
		int returnYear = scanner.nextInt();
		
		int expectedDay = scanner.nextInt();
		int expectedMonth = scanner.nextInt();
		int expectedYear = scanner.nextInt();
		
		scanner.close();
		
		return new Calendar[] { 
				new GregorianCalendar( returnYear, returnMonth - 1, returnDay ), 
				new GregorianCalendar( expectedYear, expectedMonth - 1, expectedDay )
		};
	}
	
}
