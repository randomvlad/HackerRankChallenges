package hackrank.algorithm.string.palindrome;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Palindrome Index Challenge
 * 
 * @see https://www.hackerrank.com/challenges/palindrome-index
 */
public class Solution {
	
	public static void main( String[] args ) {
		
		for ( String value : readInput( System.in ) ) {
			System.out.println( isAlmostPalindrome( value ) );
		}
	}
	
	public static int isAlmostPalindrome( String value ) {
				
		for ( int i = 0, j = value.length() - 1; i < j; i++, j-- ) {
			
			char first = value.charAt( i );
			char second = value.charAt( j );
					
			if( first != second ) {
				// try without character at "j"
				String option1 = value.substring( i, j ); 
				if ( isPalindrome( option1 ) ) {
					return j;
				} else {
					// alternative option without character at "i"
					String option2 = value.substring( i + 1, j + 1 );
					return isPalindrome( option2 ) ? i : -1;
				}
			}
		}
		
		return -1;
	}
	
	private static boolean isPalindrome( String value ) {
		
		for ( int i = 0, j = value.length() - 1; i < j; i++, j-- ) {
			if ( value.charAt( i ) != value.charAt( j ) ) {
				return false;
			}
		}
		
		return true;
	}
	
	public static List<String> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int size = scanner.nextInt();
		List<String> values = new ArrayList<>( size );
		for ( int i = 0; i < size; i++ ) {
			values.add( scanner.next() );
		}
		
		scanner.close();
		
		return values;
	}

}
