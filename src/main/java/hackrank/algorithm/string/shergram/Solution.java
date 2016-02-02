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
	
	static int countAnagramPairs( String value ) {
		
		int count = 0;
		for ( int size = 1; size < value.length(); size++ ) {
			char[][] substrings = findSubstrings( value, size );
			
			for ( int i = 0; i < substrings.length; i++ ) {
				for ( int j = i + 1; j < substrings.length; j++ ) {
					if ( isEqual( substrings[ i ], substrings[ j ] ) ) {
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	static boolean isEqual( char[] chars1, char[] chars2 ) {
		
		for ( int i = 0; i < chars1.length; i++ ) {
			if ( chars1[ i ] != chars2[ i ] ) {
				return false;
			}
		}
		
		return true;
	}
	
	static char[][] findSubstrings( String value, int size ) {
		
		int numberSubstrings = value.length() - size + 1;
		
		char[][] substrings = new char[ numberSubstrings ][];
		
		for ( int i = 0; i < numberSubstrings; i++ ) {
			
			char[] substring = new char[ size ];
			for ( int j = i, k = 0; j < i + size; j++, k++ ) {
				substring[ k ] = value.charAt( j );
			}
			
			Arrays.sort( substring );
			substrings[ i ] = substring;
		}
		
		return substrings;
	}
	
	static List<String> readInput( InputStream stream ) {
		
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
