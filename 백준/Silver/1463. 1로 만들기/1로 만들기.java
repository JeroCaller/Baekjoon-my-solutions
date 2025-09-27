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
        final int N = Integer.parseInt(br.readLine());

        if (N < 4) {
            if (N == 2 || N == 3) {
                bw.write("1");
            } else {
                bw.write("0");
            }

            return;
        }

        int[] counts = new int[N + 1];
        counts[2] = 1;
        counts[3] = 1;

        for (int i = 4; i < counts.length; ++i) {
            if (i % 3 == 0 && i % 2 == 0) {
                counts[i] = Math.min(counts[i - 1], Math.min(counts[i / 3], counts[i / 2])) + 1;
            } else if (i % 3 == 0) {
                counts[i] = Math.min(counts[i - 1], counts[i / 3]) + 1;
            } else if (i % 2 == 0) {
                counts[i] = Math.min(counts[i - 1], counts[i / 2]) + 1;
            } else {
                counts[i] = counts[i - 1] + 1;
            }
        }

        bw.write(String.valueOf(counts[N]));
    }
}
