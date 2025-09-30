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
        int[] stairs = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] memo = new int[N + 1];

        if (N >= 1) {
            memo[1] = stairs[1];
        }

        if (N >= 2) {
            memo[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= N; ++i) {
            memo[i] = Math.max(memo[i - 2] + stairs[i], memo[i - 3] + stairs[i - 1] + stairs[i]);
        }

        bw.write(String.valueOf(memo[N]));
    }
}
