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

    private static final long[] memo = new long[1000001];

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        memo[1] = 1;
        memo[2] = 2;

        long result = fibonacci(N);

        bw.write(String.valueOf(result));
    }

    private static long fibonacci(int n) {
        for (int i = 3; i <= n; ++i) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 15746;
        }

        return memo[n];
    }
}
