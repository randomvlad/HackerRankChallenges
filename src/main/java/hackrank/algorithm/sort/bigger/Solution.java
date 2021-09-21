package hackrank.algorithm.sort.bigger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Bigger is Greater Challenge
 *
 * @see https://www.hackerrank.com/challenges/bigger-is-greater
 */
public class Solution {

    public static void main(String[] args) {
        for (String word : readInputWords()) {
            String greater = findGreaterWord(word);
            System.out.println(greater != null ? greater : "no answer");
        }
    }

    private static List<String> readInputWords() {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        List<String> words = new ArrayList<>(testCases);
        for (int i = 0; i < testCases; i++) {
            words.add(scanner.next());
        }

        scanner.close();

        return words;
    }

    public static String findGreaterWord(String word) {

        char[] characters = word.toCharArray();

        for (int i = characters.length - 2; i >= 0; i--) {
            if (hasGreaterAfter(i, characters)) {
                return word.substring(0, i) + findGreaterAfter(i, characters);
            }
        }

        return null;
    }

    private static String findGreaterAfter(int index, char[] characters) {

        char letter = characters[index];

        List<Character> charsAfter = new ArrayList<>(characters.length);
        for (int i = index; i < characters.length; i++) {
            charsAfter.add(characters[i]);
        }

        // sort to impose increasing lexicographical order
        charsAfter.sort(Character::compareTo);

        char leadLetter = '-'; // guaranteed to be set by virtue of hasGreaterAfter() being true
        for (int i = 0; i < charsAfter.size(); i++) {
            if (charsAfter.get(i) > letter) {
                leadLetter = charsAfter.get(i);
                charsAfter.remove(i);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(leadLetter);
        for (char minOrderLetter : charsAfter) {
            sb.append(minOrderLetter);
        }
        return sb.toString();
    }

    private static boolean hasGreaterAfter(int index, char[] characters) {

        char max = characters[index + 1];
        for (int i = index + 2; i < characters.length; i++) {
            if (max < characters[i]) {
                max = characters[i];
            }
        }

        return max > characters[index];
    }

}
