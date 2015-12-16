package hackrank.algorithm.graph.snake;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCalc() {
				
		int[][] ladders = {
				{ 32, 62 },
				{ 42, 68 },
				{ 12, 98 }
		};
		
		int[][] snakes = {
				{ 95, 13 },
				{ 97, 25 },
				{ 93, 37 },
				{ 79, 27 },
				{ 75, 19 },
				{ 49, 47 },
				{ 67, 17 },
		};
		
		Board board = new Board( map( ladders ), map( snakes ) );
		
		assertEquals( 3, board.calculateMoves( 1, 100 ) );
		
		int[][] ladders2 = {
				{ 8, 52 },
				{ 6, 80 },
				{ 26, 42 },
				{ 2, 72 }
		};
		
		int[][] snakes2 = {
				{ 51, 19 },
				{ 39, 11 },
				{ 37, 29 },
				{ 81, 3 },
				{ 59, 5 },
				{ 79, 23 },
				{ 53, 7 },
				{ 43, 33 },
				{ 77, 21 }
		};
		
		Board board2 = new Board( map( ladders2 ), map( snakes2 ) );
		
		assertEquals( 5, board2.calculateMoves( 1, 100 ) );		
	}
	
	@Test
	public void testCalc2() {
		int[][] ladders = {
				{ 7, 98 },
		};
		
		int[][] snakes = {
				{ 99, 1 }
		};
		
		Board board = new Board( map( ladders ), map( snakes ) );
		
		assertEquals( 2, board.calculateMoves( 1, 100 ) );
	}
	
	@Test
	public void testCalcBacktrack() {
	
		int[][] ladders = {
				{ 2, 40 },
				{ 21, 99 }
		};
		
		int[][] snakes = {
				{ 41, 20 }
		};
		
		Board board = new Board( map( ladders ), map( snakes ) );
		
		assertEquals( 4, board.calculateMoves( 1, 100 ) );
	}
	
	@Test
	public void testCalcImpossible() {
		
		int[][] ladders = {
				{ 2, 93 }
		};
		
		int[][] snakes = {
				{ 94, 9 },
				{ 95, 10 },
				{ 96, 11 },
				{ 97, 12 },
				{ 98, 13 },
				{ 99, 14 }
		};
		
		Board board = new Board( map( ladders ), map( snakes ) );
		
		assertEquals( -1, board.calculateMoves( 1, 100 ) );
	}
	
	@Test
	public void testSkipShortcut() {
		
		int[][] ladders = {
				{ 2, 4 },
				{ 3, 5 },
				{ 7, 8 },
				{ 9, 99 }
		};
		
		int[][] snakes = {
				{ 10, 6 },
				{ 98, 86 }
		};
		
		Board board = new Board( map( ladders ), map( snakes ) );
		
		assertEquals( 3, board.calculateMoves( 1, 100 ) );
	}
	
	private Map<Integer,Integer> map( int[][] data ) {
		
		Map<Integer,Integer> map = new HashMap<>( data.length, 1.0f );
		
		for ( int[] row : data ) {
			map.put( row[ 0 ], row[ 1 ] );			
		}
		
		return map;
	}

}
