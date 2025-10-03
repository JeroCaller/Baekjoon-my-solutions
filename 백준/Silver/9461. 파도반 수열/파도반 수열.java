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

    private static final long[] memo = new long[101];

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 3; ++i) {
            memo[i] = 1;
        }

        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(padovan(n)));
            bw.newLine();
        }
    }

    private static long padovan(int n) {
        if (n <= 3 || memo[n] != 0) {
            return memo[n];
        }

        memo[n] = padovan(n - 2) + padovan(n - 3);
        return memo[n];
    }
}
