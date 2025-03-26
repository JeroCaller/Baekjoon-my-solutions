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
        int[][] fruits = new int[2][2];
        String[] source;
        for (int i = 0; i < 2; ++i) {
            source = br.readLine().split(" ");
            for (int j = 0; j < 2; ++j) {
                fruits[i][j] = Integer.parseInt(source[j]);
            }
        }

        int case1 = fruits[0][0] + fruits[1][1];
        int case2 = fruits[0][1] + fruits[1][0];
        int result = Math.min(case1, case2);
        bw.write(String.valueOf(result));
    }

}
