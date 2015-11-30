package hackrank.algorithm.sort.insertrun;

import java.util.Scanner;

/**
 * Insert Sort Running Time of Algorithms
 * 
 * @see https://www.hackerrank.com/challenges/runningtime
 */
public class Solution {

	public static void main( String[] args ) {
		int[] array = readInputArray();
		
		int numberShifts = insertionSort( array );
		
		System.out.println( numberShifts );
	}
	
	public static int insertionSort( int[] array ) {
		int numberShifts = 0;
		
		for ( int i = 1; i < array.length; i++ ) {
			int value = array[ i ];
			int j = i - 1;
			while ( j >= 0 && array[ j ] > value ) {
				array[ j + 1 ] = array[ j ];
				j = j - 1;
				numberShifts++;
			}
			array[ j + 1 ] = value;
		}
		
		return numberShifts;
	}
	
	private static int[] readInputArray() {
		Scanner scanner = new Scanner( System.in );

		int length = scanner.nextInt();
		int[] unsorted = new int[ length ];
		for ( int i = 0; i < length; i++ ) {
			unsorted[ i ] = scanner.nextInt();
		}
		
		scanner.close();
		
		return unsorted;
	}
}
