package hackrank.algorithm.implement.angryprof;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Angry Professor Challenge
 *
 * @see: https://www.hackerrank.com/challenges/angry-professor
 */
public class Solution {

    public static void main(String[] args) {

        for (ClassAttendance attendance : getClassAttendances()) {
            System.out.println(attendance.isProfessorAngry() ? "YES" : "NO");
        }
    }

    private static List<ClassAttendance> getClassAttendances() {
        Scanner scanner = new Scanner(System.in);

        int numberClasses = scanner.nextInt();

        List<ClassAttendance> attendances = new ArrayList<>(numberClasses);

        for (int i = 0; i < numberClasses; i++) {

            int size = scanner.nextInt();
            int minRequired = scanner.nextInt();

            ClassAttendance attendance = new ClassAttendance(size, minRequired);

            for (int j = 0; j < attendance.classSize; j++) {
                attendance.arrivalTimes.add(scanner.nextInt());
            }

            attendances.add(attendance);
        }

        scanner.close();

        return attendances;
    }

    static class ClassAttendance {

        int classSize;
        int minRequiredStudents;
        List<Integer> arrivalTimes;

        ClassAttendance(int classSize, int minRequiredStudents) {
            this.classSize = classSize;
            this.minRequiredStudents = minRequiredStudents;
            this.arrivalTimes = new ArrayList<>(classSize);
        }

        /**
         * @return true if professor is angry at lack of punctual students and cancels class.
         */
        boolean isProfessorAngry() {
            int numberOnTime = 0;
            for (int time : arrivalTimes) {
                if (time <= 0) {
                    numberOnTime++;
                }
            }

            return numberOnTime < minRequiredStudents;
        }
    }
}
