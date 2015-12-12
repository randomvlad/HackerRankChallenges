package hackrank.algorithm.graph.snake;

import static org.junit.Assert.*;

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
		
		Board board = Board.create( ladders, snakes );
		
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
		
		Board board2 = Board.create( ladders2, snakes2 );
		
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
		
		Board board = Board.create( ladders, snakes );
		
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
		
		Board board = Board.create( ladders, snakes );
		
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
		
		Board board = Board.create( ladders, snakes );
		
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
		
		Board board = Board.create( ladders, snakes );
		
		assertEquals( 3, board.calculateMoves( 1, 100 ) );
	}

}
