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
	
	int amount;
	int[] coins;
	
	CoinChanger( int amount, int[] coins ) {
		this.amount = amount;
		this.coins = coins;
	}
	
	public int countWaysMakeChange() {
		
		Set<String> ways = new HashSet<>();
		for ( int coin : coins ) {
			countWaysToMakeChange( Arrays.asList( coin ), coin, ways );
		}
		
//		for ( String way : ways ) {
//			System.out.println( way );
//		}
		
		return ways.size();
	}
	
	private void countWaysToMakeChange( List<Integer> sequence, int total, Set<String> ways ) {
		if ( total == amount ) {
			Collections.sort( sequence );
			String id = sequence.stream().map( i -> i + "" ).collect( Collectors.joining( "-" ) );
			ways.add( id );
			return;
		} else if ( total > amount ) {
			return;
		}
		
		for ( int coin : coins ) {
			List<Integer> newSequence = new ArrayList<>( sequence );
			newSequence.add( coin );
			countWaysToMakeChange( newSequence, coin + total, ways );
		}
	}
	
}
