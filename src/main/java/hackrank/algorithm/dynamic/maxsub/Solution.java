package hackrank.algorithm.dynamic.maxsub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Maximum Subarray Challenge
 * 
 * @see https://www.hackerrank.com/challenges/maxsubarray
 */
public class Solution {

	public static void main( String[] args ) {
		
		for ( List<Integer> sequence : readInput() ) {
			System.out.println( findMaxSumContiguous( sequence ) + " " +
					findMaxSumNonContigious( sequence ) );
		}
	}
	
	public static int findMaxSumNonContigious( List<Integer> sequence ) {
		
		// TODO: incorrect algorithm. Following sequence fails:
		// -1 50 -1 99 -1 50 -1000 25 -1 100 -1 25. Wrong: 148, Correct: 197
		
		int maxNegative = Integer.MIN_VALUE;
		int sum = 0;
		
		for ( int value : sequence ) {
			if ( value > 0 ) {
				sum += value;
			} else {
				if ( value > maxNegative ) {
					maxNegative = value;
				}
			}
		}
		
		return sum > 0 ? sum : maxNegative;
	}
	
	public static int findMaxSumContiguous( List<Integer> sequence ) {
		int bestSum = Integer.MIN_VALUE;
		int bestStart = 0;
		int bestEnd = 0;
		
		int currentSum = 0;
		int start = 0;
		
		for ( int i = 0; i < sequence.size(); i++ ) {
			if ( currentSum <= 0 ) {
				currentSum = 0;
				start = i;
			}
			
			currentSum += sequence.get( i );
			
			if ( currentSum >= bestSum ) {
				bestSum = currentSum;
				bestStart = start;
				bestEnd = i;
			} else {
				currentSum = 0;
			}
		}
		
		int beforeIndex = bestStart - 1;
		if ( beforeIndex >= 0 ) {
			bestSum = findMaxSumContiguous( sequence, 0, beforeIndex, bestSum );	
		}
		
		int afterIndex = bestEnd + 1;
		if ( afterIndex < sequence.size() ) {
			bestSum = findMaxSumContiguous( sequence, afterIndex, sequence.size() - 1, bestSum );	
		}
		
		return bestSum;
	}
	
	private static int findMaxSumContiguous( List<Integer> sequence, int start, int end, int sum ) {
		int bestSum = sum;
		int currentSum = sum;
		
		for ( int i = end; i >= start; i-- ) {
			int value = sequence.get( i );
			
			currentSum += value;
			if ( currentSum > bestSum ) {
				bestSum = currentSum;
			}
		}
		
		return bestSum;
	}
	
	public static List<List<Integer>> readInput() {
		
		List<List<Integer>> sequences = new ArrayList<>();
		
		Scanner scanner = new Scanner( System.in );
		
		int testCases = scanner.nextInt();
		for ( int i = 0; i < testCases; i++ ) {
			
			int length = scanner.nextInt();
			List<Integer> sequence = new ArrayList<>( length );
			
			for ( int j = 0; j < length; j++ ) {
				sequence.add( scanner.nextInt() );
			}
			
			sequences.add( sequence );
		}
		
		scanner.close();
		
		return sequences;
	}

}
