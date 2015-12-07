package hackrank.algorithm.search.missing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Missing Numbers Challenge
 * 
 * @see https://www.hackerrank.com/challenges/missing-numbers
 */
public class Solution {

	public static void main( String[] args ) {
		
		List<List<Integer>> lists = readInput();
		
		List<Integer> first = lists.get( 0 );
		List<Integer> second = lists.get( 1 );
		
		Map<Integer,Integer> counts = new HashMap<>( second.size() );
		
		for( int number : second ) {
			
			if ( ! counts.containsKey( number ) ) {
				counts.put( number, 1 );
			} else {
				int count = counts.get( number );
				count++;
				counts.put( number, count );
			}			
		}
		
		for ( int number : first ) {
			int count = counts.get( number );
			count--;
			
			if( count > 0 ) {
				counts.put( number, count );	
			} else {
				counts.remove( number );
			}
		}
		
		List<Integer> missing = new ArrayList<>( counts.keySet() ); 
		missing.sort( Integer::compareTo );
		
		for ( int number : missing ) {
			System.out.print( number + " " );
		}
	}
	
	private static List<List<Integer>> readInput() {
		
		Scanner scanner = new Scanner( System.in );
		
		List<Integer> first = new ArrayList<>();
		int lengthFirst = scanner.nextInt();
		for ( int i = 0; i < lengthFirst; i++ ) {
			first.add( scanner.nextInt() );
		}
		
		List<Integer> second = new ArrayList<>();
		int lengthSecond = scanner.nextInt();
		for ( int i = 0; i < lengthSecond; i++ ) {
			second.add( scanner.nextInt() );
		}
		
		scanner.close();
		
		return Arrays.asList( first, second );
	}

}
