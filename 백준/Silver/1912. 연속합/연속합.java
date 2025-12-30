import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] series = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; ++i) {
            series[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dp[N - 1] = series[N - 1];
        int maxTotal = dp[N - 1];

        for (int i = N - 2; i >= 0; --i) {
            dp[i] = Math.max(series[i], series[i] + dp[i + 1]);

            if (maxTotal < dp[i]) {
                maxTotal = dp[i];
            }
        }

        bw.write(String.valueOf(maxTotal));
    }
}
