package hackrank.algorithm.greedy.priyanka;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Priyanka and Toys Challenge
 * 
 * @see https://www.hackerrank.com/challenges/priyanka-and-toys
 */
public class Solution {

	public static void main( String[] args ) {
		
		List<Integer> weights = readInput( System.in );
		System.out.println( calcMinUnits( weights ) );
	}
	
	public static int calcMinUnits( List<Integer> weights ) {
		
		Collections.sort( weights );
		
		int units = 0;
		int freeRange = -1;
		
		for ( int weight : weights ) {
			if ( weight > freeRange ) {
				units++;
				freeRange = weight + 4;
			}
		}
		
		return units;
	}
	
	public static List<Integer> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int size = scanner.nextInt();
		List<Integer> weights = new ArrayList<>( size );
		for ( int i = 0; i < size; i++ ) {
			weights.add( scanner.nextInt() );
		}
		
		scanner.close();
		
		return weights;
	}

}
