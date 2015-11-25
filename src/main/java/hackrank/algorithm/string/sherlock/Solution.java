package hackrank.algorithm.string.sherlock;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Sherlock and Valid String
 * 
 * @see https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class Solution {

	public final static int ALPHABET_ENGLISH_SIZE = 26;

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );
		String value = scanner.next();
		scanner.close();

		Map<Character, Integer> counts = countChars( value );

		boolean valid = false;
		if ( hasEqualCounts( counts, '-' ) ) {
			// use '-' dummy char to check if original value is already valid and requires no fixing
			valid = true;
		} else {
			// iterate over chars to see if decrementing their count by 1 equals out other counts
			for ( char character : counts.keySet() ) {
				if ( hasEqualCounts( counts, character ) ) {
					valid = true;
					break;
				}
			}
		}

		System.out.println( valid ? "YES" : "NO" );
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

	private static boolean hasEqualCounts( Map<Character, Integer> counts, char charToReduceByOne ) {

		int firstCount = -1;

		for ( char character : counts.keySet() ) {
			int count = counts.get( character );
			if ( character == charToReduceByOne ) {
				count--;
			}

			if ( count <= 0 ) {
				continue;
			}

			if ( firstCount == -1 ) {
				firstCount = count;
				continue;
			}

			if ( firstCount != count ) {
				return false;
			}
		}

		return true;
	}

}
