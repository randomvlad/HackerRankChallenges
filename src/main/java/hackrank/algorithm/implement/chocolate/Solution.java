package hackrank.algorithm.implement.chocolate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Chocolate Feast Challenge
 * 
 * @see https://www.hackerrank.com/challenges/chocolate-feast
 */
public class Solution {

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );
		int testCases = scanner.nextInt();

		List<Integer> chocolateConsumption = new ArrayList<>( testCases );
		for ( int i = 0; i < testCases; i++ ) {
			int funds = scanner.nextInt();
			int price = scanner.nextInt();
			int wrapperExchangeRate = scanner.nextInt();
			
			int total = 0;
			int wrappers = 0;
			
			while( funds >= price ) {
				int chocolates = funds / price;
				funds = funds % price;
				
				wrappers += chocolates;
				total += chocolates;
				
				funds += wrappers / wrapperExchangeRate * price;
				wrappers = wrappers % wrapperExchangeRate;
			}
			
			chocolateConsumption.add( total );
		}
		
		scanner.close();
		
		for( int consumption : chocolateConsumption ) {
			System.out.println( consumption );
		}
	}

}
