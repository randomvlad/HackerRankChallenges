package hackrank.algorithm.string.shergram;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Sherlock and Anagrams Challenge
 * 
 * @see https://www.hackerrank.com/challenges/sherlock-and-anagrams 
 */
public class Solution {

	public static void main( String[] args ) {
		
		for ( String value : readInput( System.in ) ) {
			System.out.println( countAnagramPairs( value ) );
		}
		
	}
	
	public static int countAnagramPairs( String value ) {
		
		int count = 0;
		for ( int i = 0; i < value.length() - 1; i++ ) {
			char c = value.charAt( i );
			
			int sameNextCharIndex = value.indexOf( c, i + 1 );
			while ( sameNextCharIndex != - 1 ) {
				
				if ( sameNextCharIndex - i > 1) {
					count += 2;
				} else {
					count++;
				}
				
				sameNextCharIndex = value.indexOf( c, sameNextCharIndex + 1 );
			}
		}
		
		for ( int size = 2; size <= value.length() / 2; size++ ) {
			for ( int start = 0; start <= value.length() - size; start++ ) {
				String anagram = value.substring( start, start + size );
				String remainder = value.substring( start + size );
				
				int amount = containsAnagram( anagram, remainder );
				if ( amount > 0 ) {
					count += amount;
				}
			}
		}
		
		return count;
	}
	
	public static int containsAnagram( String anagram, String value ) {
		
		char[] charsAnagram = anagram.toCharArray();
		Arrays.sort( charsAnagram );
		
		int count = 0;
		for ( char[] token : tokenize( value, anagram.length() ) ) {
			if ( isEqual( charsAnagram, token ) ) {
				count++;
			}
		}
		
		return count;
	}
	
	private static boolean isEqual( char[] chars1, char[] chars2 ) {
		
		for ( int i = 0; i < chars1.length; i++ ) {
			if ( chars1[ i ] != chars2[ i ] ) {
				return false;
			}
		}
		
		return true;
	}
	
	private static char[][] tokenize( String value, int size ) {
		
		int numberTokens = value.length() - size + 1;
		if ( numberTokens <= 0 ) {
			return new char[ 0 ][];
		}
		
		char[][] tokens = new char[ numberTokens ][];
		
		for ( int i = 0; i < numberTokens; i++ ) {
			
			char[] token = new char[ size ];
			for ( int j = i, k = 0; j < i + size; j++, k++ ) {
				token[ k ] = value.charAt( j );
			}
			
			Arrays.sort( token );
			tokens[ i ] = token;
		}
		
		return tokens;
	}
	
	public static List<String> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int testCases = scanner.nextInt();
		
		List<String> strings = new ArrayList<>( testCases );
		for ( int t = 0; t < testCases; t++ ) {
			strings.add( scanner.next() );
		}
		
		scanner.close();
		
		return strings;
	}

}
