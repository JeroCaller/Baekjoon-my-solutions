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
    private static int[] a;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int answer = getAnswer();
        bw.write(String.valueOf(answer));
    }

    private static int getIndexOf(int[] array, int startIdx, int endIdx, int targetValue) {
        int midIdx = (startIdx + endIdx) / 2;

        while (startIdx < endIdx) {
            if (array[midIdx] < targetValue) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx;
            }

            midIdx = (startIdx + endIdx) / 2;
        }

        return startIdx;
    }

    private static int getAnswer() {
        int[] memo = new int[n + 1];
        int idx = 1;
        memo[1] = a[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            int arrayIdx = getIndexOf(memo, 1, idx, a[i]);

            if (memo[arrayIdx] == 0) {
                memo[arrayIdx] = a[i];
            } else if (memo[arrayIdx] >= a[i]) {
                memo[arrayIdx] = a[i];
            } else {
                memo[++idx] = a[i];
            }
        }

        return idx;
    }
}
