package hackrank.algorithm.greedy.toys;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Mark and Toys
 * 
 * @see https://www.hackerrank.com/challenges/mark-and-toys
 */
public class Solution {

	public static void main( String[] args ) {

		ToyStore toyStore = readInput( System.in );
		
		Arrays.sort( toyStore.prices );
		
		int spend = 0;
		int numberToys = 0;
		for ( int price : toyStore.prices ) {
			
			spend += price;
			
			if ( spend > toyStore.budget ) {
				break;
			} else {
				numberToys++;
			}
		}
		
		System.out.println( numberToys );
	}

	public static ToyStore readInput( InputStream input ) {

		Scanner scanner = new Scanner( input );

		int numberPrices = scanner.nextInt();
		int budget = scanner.nextInt();
		int[] prices = new int[ numberPrices ];

		for ( int i = 0; i < numberPrices; i++ ) {
			prices[ i ] = scanner.nextInt();
		}

		scanner.close();

		return new ToyStore( budget, prices );
	}

}

class ToyStore {

	public int budget;
	public int[] prices;

	public ToyStore( int budget, int[] prices ) {
		this.budget = budget;
		this.prices = prices;
	}

}
