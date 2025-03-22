import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        final int NUM_OF_STUDENTS = 5;
        int total = 0;
        int score;
        for (int i = 1; i <= NUM_OF_STUDENTS; ++i) {
            score = Integer.parseInt(br.readLine());
            if (score < 40) score = 40;
            total += score;
        }

        int result = total / NUM_OF_STUDENTS;
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
