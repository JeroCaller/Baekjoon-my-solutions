import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            String[] oneLine = br.readLine().split(" ");
            int[] scores = new int[oneLine.length];
            for (int j = 0; j < scores.length; ++j) {
                scores[j] = Integer.parseInt(oneLine[j]);
            }
            Arrays.sort(scores);

            if (scores[3] - scores[1] >= 4) {
                bw.write("KIN");
                bw.newLine();
                continue;
            }

            int total = 0;
            for (int j = 1; j <= 3; ++j) {
                total += scores[j];
            }
            bw.write(String.valueOf(total));
            bw.newLine();
        }
    }
}