package hackrank.algorithm.implement.team;

import java.io.InputStream;
import java.util.Scanner;

/**
 * ACM ICPC Team Challenge
 *
 * @see https://www.hackerrank.com/challenges/acm-icpc-team
 */
public class Solution {

    public static void main(String[] args) {

        Data data = readInput(System.in);

        int[] counts = new int[data.numberTopics + 1];

        for (int i = 0; i < data.numberPeople; i++) {
            for (int j = i + 1; j < data.numberPeople; j++) {
                int count = countCoverage(data.topics[i], data.topics[j]);
                counts[count]++;
            }
        }

        int[] max = getMaxTopicsAndTeams(counts);
        System.out.println(max[0]);
        System.out.println(max[1]);
    }

    public static int[] getMaxTopicsAndTeams(int[] counts) {
        int maxTopics = 0;
        int maxTeams = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            int count = counts[i];
            if (count > 0) {
                maxTopics = i;
                maxTeams = count;
                break;
            }
        }

        return new int[] { maxTopics, maxTeams };
    }

    public static int countCoverage(boolean[] topics1, boolean[] topics2) {

        int count = 0;
        for (int i = 0; i < topics1.length; i++) {
            if (topics1[i] || topics2[i]) {
                count++;
            }
        }
        return count;
    }

    public static Data readInput(InputStream stream) {
        Scanner scanner = new Scanner(stream);

        Data data = new Data();

        data.numberPeople = scanner.nextInt();
        data.numberTopics = scanner.nextInt();
        data.topics = new boolean[data.numberPeople][data.numberTopics];
        for (int i = 0; i < data.numberPeople; i++) {

            String values = scanner.next();
            for (int j = 0; j < data.numberTopics; j++) {
                data.topics[i][j] = values.charAt(j) == '1';
            }
        }

        scanner.close();

        return data;
    }

}

class Data {

    int numberPeople;
    int numberTopics;
    boolean[][] topics;
}
