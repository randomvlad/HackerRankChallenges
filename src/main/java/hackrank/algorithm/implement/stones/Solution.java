package hackrank.algorithm.implement.stones;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Manasa and Stones Challenge
 *
 * @see https://www.hackerrank.com/challenges/manasa-and-stones
 */
public class Solution {

    public static void main(String[] args) {

        for (Trail trail : readInput(System.in)) {

            Collection<Integer> numbers = findLastStoneNumbers(trail);
            System.out.println(numbers.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
        }

    }

    public static Collection<Integer> findLastStoneNumbers(Trail trail) {

        SortedSet<Integer> endings = new TreeSet<>();

        for (int a = 0; a < trail.numberStones; a++) {
            int b = trail.numberStones - 1 - a;

            int ending = a * trail.diff1 + b * trail.diff2;

            endings.add(ending);
        }

        return endings;
    }

    public static List<Trail> readInput(InputStream stream) {

        Scanner scanner = new Scanner(stream);

        int numberTests = scanner.nextInt();

        List<Trail> trails = new ArrayList<>(numberTests);

        for (int t = 0; t < numberTests; t++) {
            trails.add(new Trail(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        scanner.close();

        return trails;
    }

}

class Trail {

    int numberStones;
    int diff1;
    int diff2;

    Trail(int numberStones, int diff1, int diff2) {
        this.numberStones = numberStones;
        this.diff1 = diff1;
        this.diff2 = diff2;
    }

}
