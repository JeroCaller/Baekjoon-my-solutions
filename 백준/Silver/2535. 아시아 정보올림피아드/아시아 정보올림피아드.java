import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for (int i = 0; i < N; ++i) {
            String[] studentInfo = br.readLine().split(" ");
            students[i] = new Student(
                Integer.parseInt(studentInfo[0]),
                Integer.parseInt(studentInfo[1]),
                Integer.parseInt(studentInfo[2])
            );
        }

        Arrays.sort(students);

        int winnerIdx = 0;
        Student[] winners = new Student[3];
        Map<Integer, Integer> nationalCounter = new HashMap<>();  // nationalNum, counter

        for (Student student : students) {
            if (winnerIdx >= 3) {
                break;
            }

            if (nationalCounter.containsKey(student.getNationalNumber()) &&
            nationalCounter.get(student.getNationalNumber()) >= 2) {
                continue;
            }

            winners[winnerIdx] = student;
            ++winnerIdx;

            if (!nationalCounter.containsKey(student.getNationalNumber())) {
                nationalCounter.put(student.getNationalNumber(), 1);
            } else {
                nationalCounter.put(
                    student.getNationalNumber(),
                    nationalCounter.get(student.getNationalNumber()) + 1
                );
            }
        }

        for (Student winner : winners) {
            bw.write(winner.toString());
            bw.newLine();
        }
    }

}

class Student implements Comparable {
    private int nationalNumber;
    private int studentNumber;
    private int score;

    public Student(int nationalNumber, int studentNumber, int score) {
        this.nationalNumber = nationalNumber;
        this.studentNumber = studentNumber;
        this.score = score;
    }

    public int getNationalNumber() {
        return nationalNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%d %d", nationalNumber, studentNumber);
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return other.getScore() - this.getScore();
    }
}