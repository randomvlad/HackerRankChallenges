package hackrank.algorithm.graph.coin;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Coin Change Challenge
 * 
 * @see https://www.hackerrank.com/challenges/coin-change
 */
public class Solution {

	public static void main( String[] args ) {
		 CoinChanger changer = readInput( System.in );
		 System.out.println( changer.countWays() );
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

	public long countWays() {
		
		long[] ways = new long[ amount + 1 ];
		
		ways[ 0 ] = 1;

		for ( int i = 0; i < coins.length; i++ ) {
			int coin = coins[ i ];
			for ( int j = coin; j <= amount; j++ ) {
				ways[ j ] += ways[ j - coin ];
			}
		}
		
		return ways[ amount ];
	}
	
	public long countWaysRecursive() {
		return countRecursive( coins.length, amount );
	}
	
	private long countRecursive( int available, int value ) {
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
		return countRecursive( available - 1, value ) + countRecursive( available, reducedValue );
	}
}
