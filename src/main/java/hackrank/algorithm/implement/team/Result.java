package hackrank.algorithm.implement.team;

import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/acm-icpc-team">ACM ICPC Team</a>
 */
public class Result {

    /**
     * @param topicsKnowledge Each element is a binary string that represents a person's knowledge of available topics.
     * @return List of size 2. First element: max known topics. Second element: teams that know this many topics.
     */
    public static List<Integer> acmTeam(List<String> topicsKnowledge) {
        int numberPeople = topicsKnowledge.size();
        int numberTopics = topicsKnowledge.get(0).length();

        int[] teamKnownTopicsCount = new int[numberTopics + 1];

        for (int person1 = 0; person1 < numberPeople; person1++) {
            for (int person2 = person1 + 1; person2 < numberPeople; person2++) {
                String person1Topics = topicsKnowledge.get(person1);
                String person2Topics = topicsKnowledge.get(person2);
                int count = countTeamKnownTopics(person1Topics, person2Topics);
                teamKnownTopicsCount[count]++;
            }
        }

        int maxTopics = 0;
        int maxTeams = 0;
        for (int i = teamKnownTopicsCount.length - 1; i >= 0; i--) {
            if (teamKnownTopicsCount[i] > 0) {
                maxTopics = i;
                maxTeams = teamKnownTopicsCount[i];
                break;
            }
        }
        return Arrays.asList(maxTopics, maxTeams);
    }

    private static int countTeamKnownTopics(String person1Topics, String person2Topics) {
        int knownTopics = 0;
        for (int i = 0; i < person1Topics.length(); i++) {
            if (person1Topics.charAt(i) == '1' || person2Topics.charAt(i) == '1') {
                knownTopics++;
            }
        }
        return knownTopics;
    }
}
