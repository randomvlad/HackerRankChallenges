package hackrank.datastruct.array.sparse;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Sparce Arrays
 * 
 * @see https://www.hackerrank.com/challenges/sparse-arrays
 */
public class Solution {

	public static void main( String[] args ) {

		List<String[]> data = readInput( System.in );
		String[] values = data.get( 0 );
		String[] queries = data.get( 1 );

		// int[] counts = countBruteForce( values, queries );
		int[] counts = countHashMap( values, queries );
		for ( int count : counts ) {
			System.out.println( count );
		}
	}

	public static int[] countHashMap( String[] values, String[] queries ) {

		Map<String, Integer> occurrences = new HashMap<>();

		for ( String value : values ) {
			if ( occurrences.containsKey( value ) ) {
				int count = occurrences.get( value );
				occurrences.put( value, count + 1 );
			} else {
				occurrences.put( value, 1 );
			}
		}

		int[] counts = new int[ queries.length ];

		for ( int i = 0; i < queries.length; i++ ) {
			String query = queries[ i ];
			counts[ i ] = occurrences.containsKey( query ) ? occurrences.get( query ) : 0;
		}

		return counts;
	}

	public static int[] countBruteForce( String[] values, String[] queries ) {

		int[] counts = new int[ queries.length ];

		for ( int i = 0; i < queries.length; i++ ) {
			String query = queries[ i ];

			int count = 0;
			for ( String value : values ) {
				if ( query.equals( value ) ) {
					count++;
				}
			}

			counts[ i ] = count;
		}

		return counts;
	}

	public static List<String[]> readInput( InputStream input ) {

		Scanner scanner = new Scanner( input );

		int numberValues = scanner.nextInt();
		String[] values = new String[ numberValues ];
		for ( int i = 0; i < numberValues; i++ ) {
			values[ i ] = scanner.next();
		}

		int numberQueries = scanner.nextInt();
		String[] queries = new String[ numberQueries ];
		for ( int i = 0; i < numberQueries; i++ ) {
			queries[ i ] = scanner.next();
		}

		scanner.close();

		return Arrays.asList( values, queries );
	}

}
