package hackrank.algorithm.implement.time;

import java.util.Scanner;

/**
 * The Time in Words
 *
 * @see https://www.hackerrank.com/challenges/the-time-in-words
 */
public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        scanner.close();

        System.out.println(TimeWordFormatter.getInstance().format(hours, minutes));
    }

}

class TimeWordFormatter {

    private final static TimeWordFormatter formatter = new TimeWordFormatter();

    public static TimeWordFormatter getInstance() {
        return formatter;
    }

    private String[] words;

    private TimeWordFormatter() {
        words = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty" };
    }

    private String getNumberWord(int number) {
        if (number <= 20) {
            return words[number];
        } else {
            return words[20] + " " + words[number - 20];
        }
    }

    private String getMinutesWord(int minutes) {
        if (minutes > 30) {
            minutes = 60 - minutes;
        }

        return getNumberWord(minutes) + " minute" + (minutes == 1 ? "" : "s");
    }

    public String format(int hours, int minutes) {

        String hourWord = getNumberWord((minutes > 31 ? (hours + 1) : hours));

        if (minutes == 0) {
            return hourWord + " o' clock";
        } else if (minutes == 15) {
            return "quarter past " + hourWord;
        } else if (minutes < 30) {
            return getMinutesWord(minutes) + " past " + hourWord;
        } else if (minutes == 30) {
            return "half past " + hourWord;
        } else if (minutes == 45) {
            return "quarter to " + hourWord;
        } else if (minutes <= 59) {
            return getMinutesWord(minutes) + " to " + hourWord;
        } else {
            return "";
        }
    }
}
