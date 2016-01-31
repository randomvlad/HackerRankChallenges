package hackrank.algorithm.implement.bday;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Taum and B'day Challenge
 * 
 * @see https://www.hackerrank.com/challenges/taum-and-bday
 */
public class Solution {
	
	public static void main( String[] args ) {
		for ( GiftsPurchase purchase : readInput( System.in ) ) {
			System.out.println( purchase.calculateMinSpend() );
		}
	}
	
	public static List<GiftsPurchase> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int testCases = scanner.nextInt();

		List<GiftsPurchase> items = new ArrayList<>( testCases );
		for ( int t = 0; t < testCases; t++ ) {
			
			GiftsPurchase purchase = new GiftsPurchase();
			purchase.giftsBlack = scanner.nextInt();
			purchase.giftsWhite = scanner.nextInt();
			purchase.costBlack = scanner.nextInt();
			purchase.costWhite = scanner.nextInt();
			purchase.costConvert = scanner.nextInt();
			
			items.add( purchase );
		}
		
		scanner.close();
		
		return items;
	}

}

class GiftsPurchase {
	
	long giftsBlack;
	long giftsWhite;
	long costBlack;
	long costWhite;
	long costConvert;
	
	long calculateMinSpend() {
		
		long totalBlack = 0;
		if ( costBlack > ( costConvert + costWhite ) ) {
			totalBlack = giftsBlack * ( costConvert + costWhite );
		} else {
			totalBlack = giftsBlack * costBlack;
		}
		
		long totalWhite = 0;
		if ( costWhite > ( costConvert + costBlack ) ) {
			totalWhite = giftsWhite * ( costConvert + costBlack );
		} else {
			totalWhite = giftsWhite * costWhite;
		}
		
		return totalBlack + totalWhite;
	}
	
}