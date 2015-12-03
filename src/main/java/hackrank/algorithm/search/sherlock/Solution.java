package hackrank.algorithm.search.sherlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sherlock and Array Challenge
 * 
 * @see https://www.hackerrank.com/challenges/sherlock-and-array
 */
public class Solution {

	public static void main( String[] args ) {		
		List<List<Integer>> allNumbers = readInput();
		
		for ( List<Integer> numbers : allNumbers ) {
			System.out.println( hasEqualSumSplit( numbers ) ? "YES" : "NO" );
		}
	}
	
	private static boolean hasEqualSumSplit( List<Integer> numbers ) {		
		int total = numbers.stream().mapToInt( Integer::intValue ).sum();
		
		int leftSum = 0;
		int rightSum = total;
		
		for ( int i = 0; i < numbers.size(); i++ ) {
			int number = numbers.get( i );
			
			rightSum -= number;
			
			if ( leftSum == rightSum ) {
				return true;
			}
			
			leftSum += number;
		}
		
		return false;
	}

	private static List<List<Integer>> readInput() {
		Scanner scanner = new Scanner( System.in );

		List<List<Integer>> input = new ArrayList<>();

		int testCases = scanner.nextInt();
		for ( int i = 0; i < testCases; i++ ) {

			List<Integer> numbers = new ArrayList<>();
			int length = scanner.nextInt();
			for ( int j = 0; j < length; j++ ) {
				numbers.add( scanner.nextInt() );
			}

			input.add( numbers );
		}

		scanner.close();

		return input;
	}

}
