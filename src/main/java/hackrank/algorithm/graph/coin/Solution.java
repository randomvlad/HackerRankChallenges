package hackrank.algorithm.graph.coin;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
	private Map<Integer,Integer> results;
	
	CoinChanger( int amount, int[] coins ) {
		this.amount = amount;
		this.coins = coins;
		this.results = new HashMap<>();
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
		
		this.results.clear();
		
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
		
		if ( hasCalculation( value ) ) {
			count += getCalculation( value );
			return;
		}
		
		for ( int index = startIndex; index < coins.length; index++ ) {
			int coin = coins[ index ];
			
			int reducedValue = value - coin;
			
			if ( hasCalculation( reducedValue ) ) {
				int prevCount = getCalculation( reducedValue );
				saveCalculation( value, prevCount > 0 );
				count += prevCount;
				break;
			}
			
			if ( reducedValue == 0 ) {
				saveCalculation( value, true );
				count++;
				break;
			} else if ( reducedValue < 0 ) {
				saveCalculation( value, false );
				break;
			} else {
				countWaysMakeChange2( index, reducedValue, availableCoins - 1 );
			}
		}
		
		// subtracting the same numbers over and over again + recursive calls ... how can you remember that?
		
		/*
		 * 1-3-5
		 * 
		 * Example: $4 remaining
		 * 
		 * 4 -> List<String> 1-1-1-1, 1-3
		 * 
		 * remaining -> count
		 * 			 * 
		 * value 4, need to know how many ways I can getd to 0 from there
		 */
		
	}
	
	private void saveCalculation( int value, boolean success ) {
		if ( ! results.containsKey( value ) ) {
			results.put( value, 0 );
		}
		
		if ( success ) {
			int count = results.get( value );
			results.put( value, count + 1 );
		}
	}
	
	private boolean hasCalculation( int value ) {
		return results.containsKey( value );
	}
	
	private int getCalculation( int value ) {
		return results.get( value );
	}
	
}
