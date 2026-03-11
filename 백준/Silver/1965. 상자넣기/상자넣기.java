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
        final int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        final int[] memo = new int[N + 1];
        int memoIdx = 1;

        for (int i = 0; i < N; ++i) {
            int idx = getIndexOf(memo, memoIdx, array[i]);

            if (memo[idx] == 0) {
                memo[idx] = array[i];
                memoIdx++;
            } else if (memo[idx] > array[i]) {
                memo[idx] = array[i];
            }
        }

        bw.write(String.valueOf(memoIdx - 1));
    }

    private static int getIndexOf(int[] array, int rightIdx, int targetValue) {
        int leftIdx = 1;
        int midIdx = (leftIdx + rightIdx) / 2;

        while (leftIdx < rightIdx) {
            if (array[midIdx] == targetValue) {
                return midIdx;
            }

            if (array[midIdx] <= targetValue) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx;
            }

            midIdx = (leftIdx + rightIdx) / 2;
        }

        return midIdx;
    }
}
