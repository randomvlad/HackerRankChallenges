package hackrank.algorithm.greedy.permute;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Largest Permutation Challenge
 * 
 * @see https://www.hackerrank.com/challenges/largest-permutation
 */
public class Solution {

	public static void main( String[] args ) {
		Sequence sequence = readInput( System.in );
		System.out.println( sequence.permuteLargest().toString() );
	}

	public static Sequence readInput( InputStream stream ) {

		Scanner scanner = new Scanner( stream );

		int size = scanner.nextInt();
		int swaps = scanner.nextInt();
		List<Integer> numbers = new ArrayList<>( size );
		for ( int i = 0; i < size; i++ ) {
			numbers.add( scanner.nextInt() );
		}

		scanner.close();

		return new Sequence( numbers, swaps );
	}

}

class Sequence {

	private int maxSwaps;
	private List<Integer> numbers;
	private int[] indices;
	
	Sequence( List<Integer> numbers, int swaps ) {
		this.numbers = numbers;
		this.maxSwaps = swaps;
		
		// since numbers are 1 to N, make array size() + 1 and ignore 0th index 
		indices = new int[ numbers.size() + 1 ];
		for ( int index = 0; index < numbers.size(); index++ ) {
			int number = numbers.get( index );
			indices[ number ] = index;
		}
		
	}

	public Sequence permuteLargest() {
		
		int swaps = 0;
		int largestNumber = numbers.size();

		for ( int index = 0; index < numbers.size(); index++ ) {
			if ( swaps == maxSwaps ) {
				break;
			}

			int number = numbers.get( index );

			if ( number != largestNumber ) {
				int indexLargest = indexOf( largestNumber );
				swap( index, indexLargest );
				swaps++;
			}

			largestNumber--;
		}

		return this;
	}
	
	private int indexOf( int number ) {
		return indices[ number ];
	}

	private void swap( int indexFrom, int indexTo ) {

		int numberFrom = numbers.get( indexFrom );
		int numberTo = numbers.get( indexTo );
		numbers.set( indexFrom, numberTo );
		numbers.set( indexTo, numberFrom );
		
		indices[ numberFrom ] = indexTo;
		indices[ numberTo ] = indexFrom;
	}
	
	@Override
	public String toString() {
		return numbers.stream().map( n -> String.valueOf( n ) ).collect( Collectors.joining( " " ) );
	}

}