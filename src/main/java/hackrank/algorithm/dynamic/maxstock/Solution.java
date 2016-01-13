package hackrank.algorithm.dynamic.maxstock;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Stock Maximize Challenge
 * 
 * @see https://www.hackerrank.com/challenges/stockmax
 */
public class Solution {

	public static void main( String[] args ) {
		
		for ( List<Integer> prices : readInput( System.in ) ) {
			System.out.println( calcMaxProfit( prices ) );
		}

	}
	
	public static long calcMaxProfit( List<Integer> prices ) {
		
		long cost = 0;
		long profit = 0;
		long stocks = 0;
		
		int max = -1;
		for ( int i = 0; i < prices.size(); i++ ) {
			if ( max == -1 ) {
				max = findMax( prices, i );
			}
			
			int price = prices.get( i );
			if ( price == max ) {
				profit += price * stocks;
				stocks = 0;
				max = -1;
			} else {
				cost += price;
				stocks++;
			}
		}
		
		return profit - cost;
	}
	
	private static int findMax( List<Integer> prices, int start ) {
		int max = -1;
		for ( int i = start; i < prices.size(); i++ ) {
			int price = prices.get( i );
			if ( price > max ) {
				max = price;
			}
		}
		
		return max;
	}
	
	public static List<List<Integer>> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int testCases = scanner.nextInt();
		List<List<Integer>> data = new ArrayList<>( testCases );
		
		for ( int t = 0; t < testCases; t++ ) {
			int size = scanner.nextInt();
			List<Integer> prices = new ArrayList<>( size );
			
			for ( int i = 0; i < size; i++ ) {
				prices.add( scanner.nextInt() );
			}
			
			data.add( prices );
		}
		
		scanner.close();
		
		return data;
	}

}
