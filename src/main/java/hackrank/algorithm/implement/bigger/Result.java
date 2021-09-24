package hackrank.algorithm.implement.bigger;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://www.hackerrank.com/challenges/bigger-is-greater">Bigger is Greater</a>
 */
public class Result {

    /**
     * @param w word value
     * @return Next lexicographically greater word directly following {@code w}. If a greater word does not exist,
     * returns "no answer".
     */
    public static String biggerIsGreater(String w) {
        char[] characters = w.toCharArray();

        for (int i = characters.length - 2; i >= 0; i--) {
            if (hasGreaterAfter(i, characters)) {
                return w.substring(0, i) + findGreaterAfter(i, characters);
            }
        }

        return "no answer";
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
