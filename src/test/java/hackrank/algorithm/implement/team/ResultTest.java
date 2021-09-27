package hackrank.algorithm.implement.team;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void acmTeam_ThreePeople_FiveTopicsOneTeam() {
        List<String> topicsKnowledge = Arrays.asList("10101", "11110", "00010");
        List<Integer> maxTopicsTeams = Result.acmTeam(topicsKnowledge);
        assertThat(maxTopicsTeams).containsExactly(5, 1);
    }

    @Test
    public void acmTeam_FourPeople_FiveTopicsTwoTeams() {
        List<String> topicsKnowledge = Arrays.asList("10101", "11100", "11010", "00101");
        List<Integer> maxTopicsTeams = Result.acmTeam(topicsKnowledge);
        assertThat(maxTopicsTeams).containsExactly(5, 2);
    }
}
