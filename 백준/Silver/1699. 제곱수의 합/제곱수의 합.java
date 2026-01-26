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
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; ++i) {
            int sqrt = (int) Math.sqrt(i);

            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;
            }

            for (int j = 1; j <= sqrt; ++j) {
                int candidate = 1 + dp[i - j * j];
                dp[i] = (dp[i] == 0) ? candidate : Math.min(dp[i], candidate);
            }
        }

        bw.write(String.valueOf(dp[n]));
    }
}
