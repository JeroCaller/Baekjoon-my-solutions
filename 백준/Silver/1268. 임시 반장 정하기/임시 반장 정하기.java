import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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

        // studentNumber: [studentNumbers]
        Map<Integer, List<Integer>> students = new TreeMap<>();

        for (int i = 1; i <= N; ++i) {
            students.put(i, new ArrayList<>());
        }

        // grade: {classNumber: [studentNumbers]}
        Map<Integer, Map<Integer, List<Integer>>> table = new HashMap<>();

        for (int i = 1; i <= 5; ++i) {
            Map<Integer, List<Integer>> classes = new HashMap<>();

            for (int j = 1; j <= 9; ++j) {
                classes.put(j, new ArrayList<>());
            }

            table.put(i, classes);
        }

        for (int i = 0; i < N; ++i) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 5; ++j) {
                int classNumber = Integer.parseInt(stringTokenizer.nextToken());
                table.get(j + 1).get(classNumber).add(i + 1);
            }
        }

        for (Map<Integer, List<Integer>> subTable : table.values()) {
            for (List<Integer> studentList: subTable.values()) {
                if (studentList.size() <= 1) {
                    continue;
                }

                for (int i = 0; i < studentList.size(); ++i) {
                    List<Integer> studentsNumbers = students.get(studentList.get(i));

                    for (int j = 0; j < studentList.size(); ++j) {
                        if (i == j) {
                            continue;
                        }

                        int currentStudentNumber = studentList.get(j);
                        if (!studentsNumbers.contains(currentStudentNumber)) {
                            studentsNumbers.add(currentStudentNumber);
                        }
                    }
                }
            }
        }

        int answer = 1;
        for (int i = 2; i <= N; ++i) {
            if (students.get(answer).size() < students.get(i).size()) {
                answer = i;
            }
        }

        bw.write(String.valueOf(answer));
    }
}