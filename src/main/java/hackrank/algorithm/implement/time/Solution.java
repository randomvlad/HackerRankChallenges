package hackrank.algorithm.implement.time;

import java.util.Scanner;

/**
 * The Time in Words
 * 
 * @see https://www.hackerrank.com/challenges/the-time-in-words
 */
public class Solution {

	public static void main( String[] args ) {
		
		Scanner scanner = new Scanner( System.in );
		int hours = scanner.nextInt();
		int minutes = scanner.nextInt();
		scanner.close();

		System.out.println( toWords( hours, minutes ) );
	}
	
	public static String toWords( int hours, int minutes ) {
		
		/*
		5:00 five o' clock
		5:01 one minute past five
		5:10 ten minutes past five
		5:30 half past five
		5:40 twenty minutes to six
		5:45 quarter to six
		5:47 thirteen minutes to six
		5:28 twenty eight minutes past five
		*/
		
		return "Write me";
	}

}
