package hackrank.algorithm.string.gems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @see <a href="https://www.hackerrank.com/challenges/gem-stones">Gemstones</a>
 */
public class Result {

    /**
     * @param rocks List of strings. Each string character represents mineral in the rock
     * @return Number of gemstones found in {@code rocks}
     */
    public static int gemstones(List<String> rocks) {
        Map<Character, Set<Integer>> materialCounts = new HashMap<>();

        for (int rockId = 0; rockId < rocks.size(); rockId++) {
            String rock = rocks.get(rockId);

            for (char material : rock.toCharArray()) {
                if (!materialCounts.containsKey(material)) {
                    materialCounts.put(material, new HashSet<>());
                }

                materialCounts.get(material).add(rockId);
            }
        }

        int countGems = 0;
        for (Set<Integer> rockIds : materialCounts.values()) {
            if (rockIds.size() == rocks.size()) {
                countGems++;
            }
        }

        return countGems;
    }
}
