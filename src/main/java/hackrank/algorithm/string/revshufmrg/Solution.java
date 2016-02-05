package hackrank.algorithm.string.revshufmrg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

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
		
		StringBuilder smallest = new StringBuilder();
		for ( int i = value.length() - 1; i >= 0; i-- ) {
			if ( smallest.length() == value.length() / 2 ) {
				break;
			}
						
			char c = value.charAt( i );
			if ( c == available.peek() || counts.get( c ) == 0 ) {
				smallest.append( c );
				available.remove( c );
			} else {
				Optional<Character> nextMandatory = findNextMandatory( value, i - 1, available.peek(), counts );
				if ( nextMandatory.isPresent() ) {
					if ( c > available.peek() && c <= nextMandatory.get() ) {
						smallest.append( c );
						available.remove( c );
					} else {
						decrement( c, counts );
					}
				}
			}
		}
		
		return smallest.toString();
	}
	
	static Optional<Character> findNextMandatory( String value, int index, char availableSmallest, Map<Character,Integer> counts ) {
		
		/*
		 * TODO: need to improve
		 * 
		 * Example: look at h, next mandatory is i but between h and i, lowest available letter is c
		 * 
		 * What about two lowest available letters? like a "cde" then "i" ?
		 */
		
		Map<Character,Integer> skipped = new HashMap<>();
		
		for ( int i = index; i >= 0; i-- ) {
			
			char c = value.charAt( i );
			
			if ( c == availableSmallest ) {
				return Optional.of( c );
			} else {
				if ( ! skipped.containsKey( c ) ) {
					skipped.put( c, 1 );
				} else {
					int count = skipped.get( c );
					skipped.put( c, count + 1 );
				}
				
				if ( skipped.get( c ) > counts.get( c ) ) {
					return Optional.of( c );
				}
			}
		}
		
		return Optional.empty();
	}
	
	static void decrement( char c, Map<Character,Integer> counts ) {
		int count = counts.get( c );
		counts.put( c, count - 1 );
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
		
		for ( char c : counts.keySet() ) {
			int count = counts.get( c );
			counts.put( c, count / 2 );
			System.out.println( c + " x " + count / 2 );
		}

		return counts;
	}

	static Deque<Character> getAvailableOrdered( Map<Character, Integer> counts ) {
		
		List<Character> chars = new ArrayList<>( counts.size() );
		for ( Character c : counts.keySet() ) {
			int count = counts.get( c );
			for ( int i = 0; i < count; i++ ) {
				chars.add( c );
			}
		}

		Collections.sort( chars );
		
		return new ArrayDeque<Character>( chars );
	}

}
