package hackrank.algorithm.string.gems;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Gem Stones Challenge
 * 
 * @see https://www.hackerrank.com/challenges/gem-stones
 */
public class Solution {

	public static void main( String[] args ) {

		List<String> rocks = readInput( System.in );
		System.out.println( countGemElements( rocks ) );
	}
	
	public static int countGemElements( List<String> rocks ) {
		
		Map<Character,Set<Integer>> materialCounts = new HashMap<>( 26, 1.0f );
		
		for ( int rockId = 0; rockId < rocks.size(); rockId ++ ) {
			String rock = rocks.get( rockId );
			
			for ( int i = 0; i < rock.length(); i++ ) {
				char material = rock.charAt( i );
				
				if ( ! materialCounts.containsKey( material ) ) {
					materialCounts.put( material, new HashSet<Integer>() );
				}
				
				materialCounts.get( material ).add( rockId );
			}
		}
		
		int countGems = 0;
		for ( Set<Integer> rockIds : materialCounts.values() ) {
			if ( rockIds.size() == rocks.size() ) {
				countGems++;
			}
		}
		
		return countGems;
	}
	
	public static List<String> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int size = scanner.nextInt();
		List<String> rocks = new ArrayList<>( size );
		
		for ( int i = 0; i < size; i++ ) {
			rocks.add( scanner.next() );
		}
		
		scanner.close();
		
		return rocks;
	}

}
