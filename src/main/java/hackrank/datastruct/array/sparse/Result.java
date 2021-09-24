package hackrank.datastruct.array.sparse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>Disclaimer: HackerRank named the problem "sparse arrays", but it nothing to do with actual sparse arrays.</p>
 *
 * @see <a href="https://www.hackerrank.com/challenges/sparse-arrays">Sparse Arrays</a>
 */
public class Result {

    /**
     * @param strings List of strings to search in
     * @param queries List of search queries to look for matches in {@code strings}
     * @return List of match counts for specified {@code queries}
     */
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        Map<String, Integer> stringCounts = new HashMap<>();

        for (String value : strings) {
            if (stringCounts.containsKey(value)) {
                int count = stringCounts.get(value);
                stringCounts.put(value, count + 1);
            } else {
                stringCounts.put(value, 1);
            }
        }

        return queries.stream().map(query -> stringCounts.getOrDefault(query, 0)).collect(Collectors.toList());
    }
}
