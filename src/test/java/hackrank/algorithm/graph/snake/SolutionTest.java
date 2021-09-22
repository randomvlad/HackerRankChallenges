package hackrank.algorithm.graph.snake;

import static org.assertj.core.api.Assertions.assertThat;

import hackrank.algorithm.graph.snake.Solution.Board;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void quickestWayUp_BigLadder_ThreeDiceRolls() {
        //@formatter:off
        int[][] ladders = {
                { 32, 62 },
                { 42, 68 },
                { 12, 98 } // should take this ladder
        };

        int[][] snakes = {
                { 95, 13 },
                { 97, 25 },
                { 93, 37 },
                { 79, 27 },
                { 75, 19 },
                { 49, 47 },
                { 67, 17 }
        };
        //@formatter:on

        Board board = create(ladders, snakes);

        int numberDiceRolls = board.quickestWayUp(1, 100);
        assertThat(numberDiceRolls).isEqualTo(3);
    }

    @Test
    public void quickestWayUp_BigLadder_FiveDiceRolls() {
        //@formatter:off
        int[][] ladders = {
                { 2, 72 },
                { 6, 80 }, // should take this ladder
                { 8, 52 },
                { 26, 42 }
        };

        int[][] snakes = {
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
        //@formatter:on

        Board board = create(ladders, snakes);

        int numberDiceRolls = board.quickestWayUp(1, 100);

        assertThat(numberDiceRolls).isEqualTo(5);
    }

    @Test
    public void quickestWayUp_BigLadderOneRollAway_TwoDiceRolls() {
        //@formatter:off
        int[][] ladders = {
                { 7, 98 }, // accessible when a six is rolled
        };

        int[][] snakes = {
                { 99, 1 }
        };
        //@formatter:on

        Board board = create(ladders, snakes);

        int numberDiceRolls = board.quickestWayUp(1, 100);

        assertThat(numberDiceRolls).isEqualTo(2);
    }

    @Test
    public void quickestWayUp_TwoLaddersOneSnake_TakeLadderThenSnakeThenLadder() {
        //@formatter:off
        int[][] ladders = {
                { 2, 40 }, // take first
                { 21, 99 } // take third
        };

        int[][] snakes = {
                { 41, 20 } // take second
        };
        //@formatter:on

        Board board = create(ladders, snakes);

        int numberDiceRolls = board.quickestWayUp(1, 100);

        assertThat(numberDiceRolls).isEqualTo(4);
    }

    @Test
    public void quickestWayUp_ImpossibleAllSnakesAtEnd_NegativeOne() {
        //@formatter:off
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
        //@formatter:on

        Board board = create(ladders, snakes);

        int numberDiceRolls = board.quickestWayUp(1, 100);

        assertThat(numberDiceRolls).isEqualTo(-1);
    }

    @Test
    public void quickestWayUp_SuboptimalLadders_SkipSuboptimalLadders() {
        //@formatter:off
        int[][] ladders = {
                { 2, 4 }, // skip suboptimal
                { 3, 5 }, // skip suboptimal
                { 7, 8 }, // skip suboptimal
                { 9, 99 } // take
        };

        int[][] snakes = {
                { 10, 6 },
                { 98, 86 }
        };
        //@formatter:on

        Board board = create(ladders, snakes);

        int numberDiceRolls = board.quickestWayUp(1, 100);

        assertThat(numberDiceRolls).isEqualTo(3);
    }

    private Board create(int[][] ladders, int[][] snakes) {
        Map<Integer, Integer> mapLadders = toMap(ladders);
        Map<Integer, Integer> mapSnakes = toMap(snakes);
        return new Board(100, mapLadders, mapSnakes);
    }

    private Map<Integer, Integer> toMap(int[][] data) {
        return Stream.of(data).collect(Collectors.toMap(item -> item[0], item -> item[1]));
    }
}
