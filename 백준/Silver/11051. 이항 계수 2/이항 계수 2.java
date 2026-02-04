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

    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] conditions = br.readLine().split(" ");
        final int N = Integer.parseInt(conditions[0]);
        final int K = Integer.parseInt(conditions[1]);
        memo = new int[K + 1][N + 1];
        bw.write(String.valueOf(getAnswer(N, K)));
    }

    private static int getAnswer(int n, int k) {
        if (k == 0 || n == k) {
            memo[k][n] = 1;
            return 1;
        }

        if (memo[k][n] != 0) {
            return memo[k][n];
        }

        memo[k][n] = getAnswer(n - 1, k) + getAnswer(n - 1, k - 1);
        return memo[k][n] % 10007;
    }
}
