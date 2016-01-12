package hackrank.algorithm.greedy.boardcut;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Cutting Boards
 * 
 * @see https://www.hackerrank.com/challenges/board-cutting
 */
public class Solution {

	public static void main( String[] args ) {
		
		for ( Board board : readInput( System.in ) ) {
			System.out.println( ( findMinCost( board ) % 1_000_007 ) );
		}
	}
	
	public static long findMinCost( Board board ) {
		
		List<Long> costHeights = board.costHeight;
		Collections.sort( costHeights, Collections.reverseOrder() );
		List<Long> costWidths = board.costWidth;
		Collections.sort( costWidths, Collections.reverseOrder() );
		
		int indexCostHeight = 0;
		int indexCostWidth = 0;
		int widthCuts = 1;
		int heightCuts = 1;		
		long cost = 0;
		
		while ( indexCostHeight < costHeights.size() || indexCostWidth < costWidths.size() ) {
			
			if ( indexCostHeight < costHeights.size() && indexCostWidth < costWidths.size() ) {
				long costWidth = costWidths.get( indexCostWidth ) * heightCuts;	
				long costHeight = costHeights.get( indexCostHeight ) * widthCuts;
				
				if ( costWidth > costHeight ) {
					cost += costWidth;
					widthCuts++;
					indexCostWidth++;
				} else {
					cost += costHeight;
					heightCuts++;
					indexCostHeight++;
				}	
			} else if ( indexCostHeight < costHeights.size() ) {
				long costHeight = costHeights.get( indexCostHeight ) * widthCuts;
				cost += costHeight;
				heightCuts++;
				indexCostHeight++;
			} else {
				long costWidth = costWidths.get( indexCostWidth ) * heightCuts;
				cost += costWidth;
				widthCuts++;
				indexCostWidth++;
			}			
		}
		
		return cost;
	}
	
	public static List<Board> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int size = scanner.nextInt();
		List<Board> boards = new ArrayList<>( size );
		
		for ( int i = 0; i < size; i++ ) {
			
			int height = scanner.nextInt();
			int width = scanner.nextInt();
				
			List<Long> costHeights = new ArrayList<>( height - 1 );
			for ( int h = 0; h < height - 1; h++ ) {
				costHeights.add( scanner.nextLong() );
			}
			
			List<Long> costWidths = new ArrayList<>( width - 1 );
			for ( int w = 0; w < width - 1; w++ ) {
				costWidths.add( scanner.nextLong() );
			}
			
			boards.add( new Board( height, width, costHeights, costWidths ) );
		}
		
		scanner.close();

		return boards;
	}

}

class Board {
	
	int height;
	int width;
	
	List<Long> costHeight;
	List<Long> costWidth;
	
	Board( int height, int width, List<Long> costHeight, List<Long> costWidth ) {
		this.height = height;
		this.width = width;
		this.costHeight = costHeight;
		this.costWidth = costWidth;
	}
	
}