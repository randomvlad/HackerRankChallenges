package hackrank.algorithm.implement.time;

/**
 * @see <a href="https://www.hackerrank.com/challenges/the-time-in-words">The Time in Words</a>
 */
public class Result {

    /**
     * @param hours   the hour of the day
     * @param minutes the minutes after the hour
     * @return Time in words format for {@code hours} and {@code minutes}
     */
    public static String timeInWords(int hours, int minutes) {
        TimeInWordsFormatter formatter = new TimeInWordsFormatter();
        return formatter.format(hours, minutes);
    }

    public static class TimeInWordsFormatter {

        private static final String[] WORDS =
                { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                        "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                        "twenty" };

        public String format(int hours, int minutes) {
            if (minutes == 0) {
                return getNumberWord(hours) + " o' clock";
            } else if (minutes == 15) {
                return "quarter past " + getNumberWord(hours);
            } else if (minutes < 30) {
                return getMinutesWord(minutes) + " past " + getNumberWord(hours);
            } else if (minutes == 30) {
                return "half past " + getNumberWord(hours);
            } else if (minutes == 45) {
                return "quarter to " + getNumberWord(hours + 1);
            } else {
                return getMinutesWord(minutes) + " to " + getNumberWord(hours + 1); // minutes must be >= 31
            }
        }

        private String getNumberWord(int number) {
            if (number <= 20) {
                return WORDS[number];
            } else {
                return WORDS[20] + " " + WORDS[number - 20];
            }
        }

        private String getMinutesWord(int minutes) {
            if (minutes > 30) {
                minutes = 60 - minutes;
            }

            return getNumberWord(minutes) + " minute" + (minutes == 1 ? "" : "s");
        }
    }
}
