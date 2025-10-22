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
        bw.write(String.valueOf(findAnswer(N)));
    }

    private static int findAnswer(int n) {
        if (n <= 3) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 3;

        for (int i = 4; i <= n; ++i) {
            int largestSquare = (int) Math.sqrt(i);

            for (int j = largestSquare; j > 0; --j) {
                int remainNum = i - (int) Math.pow(j, 2);

                if (memo[i] == 0 || memo[i] > 1 + memo[remainNum]) {
                    memo[i] = 1 + memo[remainNum];
                }
            }
        }

        return memo[n];
    }
}
