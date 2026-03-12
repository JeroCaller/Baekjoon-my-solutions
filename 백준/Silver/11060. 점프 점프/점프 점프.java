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

    private static int n;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        final int[] memo = new int[n];

        for (int i = n - 2; i >= 0; --i) {
            for (int j = 1; j <= array[i]; ++j) {
                if (i + j > n - 1) break;
                if (i + j != n - 1 && memo[i + j] == 0) continue;

                if (memo[i] == 0) {
                    memo[i] = 1 + memo[i + j];
                } else {
                    memo[i] = Math.min(memo[i], 1 + memo[i + j]);
                }
            }
        }

        if (memo[0] == 0 && n != 1) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(memo[0]));
        }
    }
}
