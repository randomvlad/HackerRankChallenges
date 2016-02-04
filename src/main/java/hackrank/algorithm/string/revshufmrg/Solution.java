package hackrank.algorithm.string.revshufmrg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Reverse Shuffle Merge Challenge
 * 
 * @see https://www.hackerrank.com/challenges/reverse-shuffle-merge
 */
public class Solution {
	
	public static void main( String[] args ) {
		
		Scanner scanner = new Scanner( System.in );
		String value = scanner.next();
		scanner.close();
		
		
		/*
		Input:
		bdabaceadaedaaaeaecdeadababdbeaeeacacaba

		Go from reverse & pick lowest (while available), avoid higher letters while possible (haven't skipped max alloted):
	
		aaaa aaba acee dede cbdb
		
		
		 */
		
		Map<Character,Integer> counts = new HashMap<>();
		
		for ( int i = 0; i < value.length(); i++ ) {
			char c = value.charAt( i );
			
			if ( ! counts.containsKey( c ) ) {
				counts.put( c, 1 );
			} else{
				int count = counts.get( c );
				counts.put( c, count + 1 );
			}
		}
		
		List<Character> chars = new ArrayList<>( value.length() / 2 );
		for ( Character c : counts.keySet() ) {
			int count = counts.get( c );
			for ( int i = 0; i < count / 2; i++ ) {
				chars.add( c );
			}
		}
		
		Collections.sort( chars );
		
		System.out.println( chars.stream().map( c -> c.toString() ).collect( Collectors.joining( "" ) )  );
	}

}
