package hackrank.algorithm.implement.team;

import java.io.InputStream;
import java.util.Scanner;

/**
 * ACM ICPC Team Challenge
 * 
 * @see https://www.hackerrank.com/challenges/acm-icpc-team
 */
public class Solution {

	public static void main( String[] args ) {

		int[][] people = readInput( System.in );
		
		int[] counts = new int[ people[ 0 ].length + 1 ];
		
		for ( int i = 0; i < people.length; i++ ) {
			for ( int j = i + 1; j < people.length; j++ ) {
				int count = countCoverage( people[ i ], people[ j ] );
				counts[ count ]++;
			}
		}
		
		int[] max = getMaxTopicsAndTeams( counts );
		System.out.println( max[ 0 ] );
		System.out.println( max[ 1 ] );
	}
	
	public static int[] getMaxTopicsAndTeams( int[] counts ) {
		int maxTopics = 0;
		int maxTeams = 0;
		for ( int i = counts.length - 1; i >= 0; i-- ) {
			int count = counts[ i ];
			if ( count > 0 ) {
				maxTopics = i;
				maxTeams = count;
				break;
			}
		}
		
		return new int[] { maxTopics, maxTeams };
	}
	
	public static int countCoverage( int[] topics1, int[] topics2 ) {
		
		int count = 0;
		for ( int i = 0; i < topics1.length; i++ ) {
			if ( topics1[ i ] == 1 || topics2[ i ] == 1 ) {
				count++;
			}
		}
		
		return count;
	}
	
	
	public static int[][] readInput( InputStream stream ) {
		Scanner scanner = new Scanner( stream );
		
		int numberPeople = scanner.nextInt();
		int numberTopics = scanner.nextInt();
		
		int[][] data = new int[ numberPeople ][ numberTopics ];
		for ( int i = 0; i < numberPeople; i++ ) {
			
			String topics = scanner.next();
			for ( int j = 0; j < topics.length(); j++ ) {
				data[ i ][ j ] = Integer.valueOf( topics.charAt( j ) + "" );
			}
		}
		
		scanner.close();
		
		return data;
	}

}
