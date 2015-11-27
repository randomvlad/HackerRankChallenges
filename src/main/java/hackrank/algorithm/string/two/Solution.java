package hackrank.algorithm.string.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Two Strings Challenge
 *
 * @see https://www.hackerrank.com/challenges/two-strings
 */
public class Solution {

	public final static int ALPHABET_ENGLISH_SIZE = 26;

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );
		int testCases = scanner.nextInt();

		List<Boolean> results = new ArrayList<>( testCases );
		for ( int i = 0; i < testCases; i++ ) {

			String first = scanner.next();
			Map<Character, Integer> firstCounts = countChars( first );

			String second = scanner.next();
			Map<Character, Integer> secondCounts = countChars( second );

			boolean hasSubstring = false;
			for ( char character : firstCounts.keySet() ) {
				if( secondCounts.containsKey( character ) ) {
					hasSubstring = true;
					break;
				}
			}
			
			results.add( hasSubstring );
		}

		scanner.close();
		
		for( boolean hasSubstring : results ) {
			System.out.println( hasSubstring ? "YES" : "NO" );
		}
	}

	private static Map<Character, Integer> countChars( String value ) {

		Map<Character, Integer> counts = new HashMap<>( ALPHABET_ENGLISH_SIZE );
		for ( char character : value.toCharArray() ) {
			if ( !counts.containsKey( character ) ) {
				counts.put( character, 0 );
			}

			int count = counts.get( character );
			count++;
			counts.put( character, count );
		}

		return counts;
	}

}
