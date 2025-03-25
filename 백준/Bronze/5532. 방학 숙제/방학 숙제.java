import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        int[] input = new int[5];
        for (int i = 0; i < 5; ++i) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int daysForKorean = getDaysToSolve(input[1], input[3]);
        int daysForMath = getDaysToSolve(input[2], input[4]);
        int result = (daysForKorean >= daysForMath) ?
            input[0] - daysForKorean : input[0] - daysForMath;
        bw.write(String.valueOf(result));
    }

    public static int getDaysToSolve(int goal, int perDay) {
        int q = goal / perDay;
        int r = goal % perDay;
        if (r != 0) {
            ++q;
        }
        return q;
    }

}
