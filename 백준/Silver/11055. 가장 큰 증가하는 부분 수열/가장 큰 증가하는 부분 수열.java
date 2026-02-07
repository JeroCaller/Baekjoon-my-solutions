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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[N];

        for (int i = 0; i < N; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[N];

        for (int i = 0; i < N; ++i) {
            memo[i] = a[i];
        }

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (a[j] < a[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + a[i]);
                }
            }
        }

        int maximum = memo[0];

        for (int i = 1; i < N; ++i) {
            maximum = Math.max(maximum, memo[i]);
        }

        bw.write(String.valueOf(maximum));
    }
}
