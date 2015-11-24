package hackrank.algorithm.implement.caesar;

import java.util.Scanner;

/**
 * Caesar Cipher Challenge
 * 
 * @see https://www.hackerrank.com/challenges/caesar-cipher-1
 */
public class Solution {

	public final static int ALPHABET_ENGLISH_SIZE = 26;
	public final static int ASCII_Z_UPPER_CASE = 90;
	public final static int ASCII_Z_LOWER_CASE = 122;

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );

		int messageLength = scanner.nextInt();
		String message = scanner.next();
		int rotation = scanner.nextInt();

		scanner.close();

		StringBuilder encrypted = new StringBuilder();
		for ( char character : message.toCharArray() ) {
			encrypted.append( rotate( character, rotation ) );
		}

		System.out.println( encrypted );
	}

	private static char rotate( char character, int distance ) {
		if ( !Character.isLetter( character ) ) {
			return character;
		}
		
		int rotated = (int)character + (distance % ALPHABET_ENGLISH_SIZE);
		
		boolean wrap = false;
		if ( Character.isUpperCase( character ) ) {
			wrap = rotated > ASCII_Z_UPPER_CASE;
		} else {
			wrap = rotated > ASCII_Z_LOWER_CASE;
		}
		
		if ( wrap ) {
			rotated -= ALPHABET_ENGLISH_SIZE;
		}

		return (char)rotated;
	}

}
