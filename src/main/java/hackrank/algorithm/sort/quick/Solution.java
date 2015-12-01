package hackrank.algorithm.sort.quick;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Quicksort Challenge
 * 
 * @see https://www.hackerrank.com/challenges/quicksort2
 */
public class Solution {
	
	public static void main( String[] args ) {
		
		sort( readInput() );
		
	}
	
	private static List<Integer> sort( List<Integer> list ) {
		if ( list.size() < 2 ) {
			return list;
		}
		
		int pivot = list.get( 0 );
		
		int maxSize = list.size() - 1;
		List<Integer> left = new ArrayList<>( maxSize );
		List<Integer> right = new ArrayList<>( maxSize );
		
		for ( int i = 1; i < list.size(); i++ ) {
			int number = list.get( i );
			
			if ( number < pivot ) {
				left.add( number );
			} else {
				right.add( number );
			}
		}
		
		left = sort( left );
		right = sort( right );
		
		List<Integer> sorted = new ArrayList<>( list.size() );
		
		sorted.addAll( left );
		sorted.add( pivot );
		sorted.addAll( right );
		
		System.out.println( sorted.stream().map( i -> i.toString() ).collect( Collectors.joining( " " ) ) );
		
		return sorted;
	}
	
	private static List<Integer> readInput() {
		Scanner scanner = new Scanner( System.in );

		int length = scanner.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for ( int i = 0; i < length; i++ ) {
			list.add( scanner.nextInt() );
		}
		
		scanner.close();
		
		return list;
	}

}
