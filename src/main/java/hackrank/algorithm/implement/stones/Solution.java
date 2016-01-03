package hackrank.algorithm.implement.stones;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Manasa and Stones Challenge
 * 
 * @see https://www.hackerrank.com/challenges/manasa-and-stones
 */
public class Solution {

	public static void main( String[] args ) {
		
		for ( Trail trail : readInput( System.in ) ) {
			
			List<Integer> numbers = findLastStoneNumbers( trail );
			System.out.println( numbers.stream().map( i -> String.valueOf( i ) ).collect( Collectors.joining( " " ) ) );
		}
		
	}
	
	public static List<Integer> findLastStoneNumbers( Trail trail ) {
		
		List<Integer> endings = new ArrayList<>();
		
		/*
		 * first stone = 0
		 * number of stones 3, with diff 1 or 2
		 * 
		 * 1 1 -> 0, 1, 2
		 * 1 2 -> 0, 1, 3
		 * 2 1 -> 0, 2, 3
		 * 2 2 -> 0, 2, 4
		 */
		
		return endings;
	}
	
	public static List<Trail> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int numberTests = scanner.nextInt();
		
		List<Trail> trails = new ArrayList<>( numberTests );
		
		for ( int t = 0; t < numberTests; t++ ) {
			trails.add( new Trail( scanner.nextInt(), scanner.nextInt(), scanner.nextInt() ) );
		}
		
		scanner.close();
		
		return trails;
	}

}

class Trail {
	
	int numberStones;
	int diff1;
	int diff2;
	
	Trail( int numberStones, int diff1, int diff2 ) {
		this.numberStones = numberStones;
		this.diff1 = diff1;
		this.diff2 = diff2;
	}
	
}
