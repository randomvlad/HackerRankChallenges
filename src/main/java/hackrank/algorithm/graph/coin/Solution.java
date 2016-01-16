package hackrank.algorithm.graph.coin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
	private int count;
	
	CoinChanger( int amount, int[] coins ) {
		this.amount = amount;
		this.coins = coins;
	}
	
	public int countWaysMakeChange() {
		
		Arrays.sort( coins );
		count = 0;
		countWaysMakeChange( 0, 0 );
		return count;
	}
	
	private void countWaysMakeChange( int startIndex, int total ) {
		
		for ( int index = startIndex; index < coins.length; index++ ) {
			int coin = coins[ index ];
			
			int newTotal = coin + total;
			if ( newTotal > amount ) {
				break; // no point in trying any further coins since they are greater
			} else if ( newTotal == amount ) {
				count++;
				break;
			} else {
				countWaysMakeChange( index, newTotal );	
			}
		}
	}
	
	public int countWaysMakeChange2() {
		
		Arrays.sort( coins );
		
		int smallestCoin = coins[ 0 ];
		int maxNumberCoins = amount / smallestCoin; 
		
		count = 0;
		countWaysMakeChange2( 0, amount, maxNumberCoins );
		return count;
	}
	
	public void countWaysMakeChange2( int startIndex, int value, int availableCoins ) {		
		if ( availableCoins == 0 ) {
			return;
		}
		
		for ( int index = startIndex; index < coins.length; index++ ) {
			int coin = coins[ index ];
			
			int reducedValue = value - coin;
			if ( reducedValue == 0 ) {
				count++;
				break;
			} else if ( reducedValue < 0 ) {
				break;
			} else {
				countWaysMakeChange2( index, reducedValue, availableCoins - 1 );
			}
		}
	}
	
}
