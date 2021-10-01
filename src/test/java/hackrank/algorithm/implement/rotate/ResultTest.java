package hackrank.algorithm.implement.rotate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void rotateMatrixLayers_SquareRotateOnce_ExpectedRotation() {
        List<List<Integer>> matrix = createMatrix(//@formatter:off
                "1 2 3",
                "8 9 4",
                "7 6 5"
        );//@formatter:on

        Result.rotateMatrixLayers(matrix, 1);

        assertMatrixEquals(//@formatter:off
                matrix,
                "2 3 4",
                "1 9 5",
                "8 7 6"
        );//@formatter:on
    }

    @Test
    void rotateMatrixLayers_IdentityRotations_SkipRotations() {
        List<List<Integer>> matrix = createMatrix(//@formatter:off
                "1 2",
                "4 3"
        );//@formatter:on

        Result.rotateMatrixLayers(matrix, 4 * 100_000_000);

        assertMatrixEquals(//@formatter:off
                matrix,
                "1 2",
                "4 3"
        );//@formatter:on
    }

    @Test
    void rotateMatrixLayers_TwoLayersRotateTwice_ExpectedRotations() {
        List<List<Integer>> matrix = createMatrix(//@formatter:off
                "10 11 12 13",
                "21 90 91 14",
                "20 94 92 15",
                "19 18 17 16"
        );//@formatter:on

        Result.rotateMatrixLayers(matrix, 2);

        assertMatrixEquals(//@formatter:off
                matrix,
                "12 13 14 15",
                "11 92 94 16",
                "10 91 90 17",
                "21 20 19 18"
        );//@formatter:on
    }

    private static void assertMatrixEquals(List<List<Integer>> actualMatrix, String... expectedRows) {
        String actualDisplay = Result.getStringDisplay(actualMatrix);
        String expectedDisplay = Result.getStringDisplay(createMatrix(expectedRows));
        assertThat(actualDisplay).isEqualTo(expectedDisplay);
    }

    private static List<List<Integer>> createMatrix(String... rows) {
        return Arrays.stream(rows).map(ResultTest::createMatrixRow).collect(Collectors.toList());
    }

    private static List<Integer> createMatrixRow(String row) {
        return Arrays.stream(row.split(" ")).map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
    }
}
