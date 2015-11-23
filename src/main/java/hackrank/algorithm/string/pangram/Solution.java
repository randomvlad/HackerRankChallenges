package hackrank.algorithm.string.pangram;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Pangrams Challenge
 * 
 * @see https://www.hackerrank.com/challenges/pangrams
 *
 */
public class Solution {

	public final static int ALPHABET_ENGLISH_SIZE = 26;

	public static void main( String[] args ) {
		Scanner scanner = new Scanner( System.in );
		scanner.useDelimiter( "\\n" );

		String text = scanner.next();

		scanner.close();

		System.out.println( (isPangram( text ) ? "pangram" : "not pangram") );
	}

	private static boolean isPangram( String text ) {
		text = text.toLowerCase().replaceAll( "[^a-z]", "" );

		if ( text.length() < ALPHABET_ENGLISH_SIZE ) {
			return false;
		}

		Set<Character> alphabetLetters = new HashSet<>();
		for ( char character : text.toCharArray() ) {
			alphabetLetters.add( character );
		}
		
		return alphabetLetters.size() == ALPHABET_ENGLISH_SIZE;
	}

}
