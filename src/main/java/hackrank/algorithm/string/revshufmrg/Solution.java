package hackrank.algorithm.string.revshufmrg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Reverse Shuffle Merge Challenge
 * 
 * @see https://www.hackerrank.com/challenges/reverse-shuffle-merge
 */
public class Solution {

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );
		String value = scanner.next();
		scanner.close();

		System.out.println( decodeSmallestLexi( value ) );
	}

	public static String decodeSmallestLexi( String value ) {

		Map<Character, Integer> counts = groupByChar( value );
		Deque<Character> available = getAvailableOrdered( counts );
		
//		System.out.println( available );
		
		StringBuilder smallest = new StringBuilder();
		for ( int i = value.length() - 1; i >= 0; i-- ) {
			if ( smallest.length() == value.length() / 2 ) {
				break;
			}
			
			char c = value.charAt( i );
			
			if ( c == available.peek() ) {				
				smallest.append( available.pop() );
				decrement( c, counts );
			} else if ( counts.get( c ) == 0 && available.contains( c ) ) {
				available.remove( c );
				smallest.append( c );	
			} else {
				decrement( c, counts );
			}
		}
		
		return smallest.toString();
	}
	
	static void decrement( char c, Map<Character,Integer> counts ) {
		int count = counts.get( c );
		counts.put( c, count - 2 );
	}

	static Map<Character, Integer> groupByChar( String value ) {

		Map<Character, Integer> counts = new HashMap<>();

		for ( int i = 0; i < value.length(); i++ ) {
			char c = value.charAt( i );

			if ( !counts.containsKey( c ) ) {
				counts.put( c, 1 );
			} else {
				int count = counts.get( c );
				counts.put( c, count + 1 );
			}
		}
		
//		for ( char c : counts.keySet() ) {
//			System.out.println( c + " x " + ( counts.get( c ) / 2 ) );
//		}

		return counts;
	}

	static Deque<Character> getAvailableOrdered( Map<Character, Integer> counts ) {
		
		List<Character> chars = new ArrayList<>( counts.size() / 2 );
		for ( Character c : counts.keySet() ) {
			int count = counts.get( c );
			for ( int i = 0; i < count / 2; i++ ) {
				chars.add( c );
			}
		}

		Collections.sort( chars );

		return new ArrayDeque<Character>( chars );
	}

}
