package hackrank.algorithm.graph.coin;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

// http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/

/**
 * Coin Change Challenge
 * 
 * @see https://www.hackerrank.com/challenges/coin-change
 */
public class Solution {

	public static void main( String[] args ) {
		 CoinChanger changer = readInput( System.in );
		 System.out.println( changer.countWaysMakeChange() );
	}

	public static long countNoMem( int coins[], int available, int value ) {
		if ( value == 0 ) {
			return 1;
		}

		if ( value < 0 ) {
			return 0;
		}

		if ( available <= 0 && value >= 1 ) {
			return 0;
		}

		int reducedValue = value - coins[ available - 1 ];
		return countNoMem( coins, available - 1, value ) + countNoMem( coins, available, reducedValue );
	}

	public static CoinChanger readInput( InputStream stream ) {

		Scanner scanner = new Scanner( stream );

		int amount = scanner.nextInt();
		int size = scanner.nextInt();

		int[] coins = new int[ size ];
		for ( int i = 0; i < size; i++ ) {
			coins[ i ] = scanner.nextInt();
		}

		scanner.close();

		return new CoinChanger( amount, coins );
	}

}

class CoinChanger {

	private int amount;
	private int[] coins;

	CoinChanger( int amount, int[] coins ) {
		this.amount = amount;
		this.coins = coins;
	}

	public long countWaysMakeChange() {
		Arrays.sort( coins );
		return count( coins.length, amount );
	}
	
	private long count( int available, int value ) {
		
		long[] table = new long[ value + 1 ];
		
		table[ 0 ] = 1;

		for ( int i = 0; i < available; i++ ) {
			for ( int j = coins[ i ]; j <= value; j++ ) {
				table[ j ] += table[ j - coins[ i ] ];
			}
		}

		return table[ value ];
	}
}
