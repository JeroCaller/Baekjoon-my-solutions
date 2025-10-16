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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int K = Integer.parseInt(firstLine[1]);
        int[] temperatures = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            temperatures[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxTotal = -100 * 100000;
        int endIdx = K - 1;

        for (int i = 0; endIdx < N; ++i) {
            int total = 0;

            for (int j = i; j <= endIdx; ++j) {
                total += temperatures[j];
            }

            if (maxTotal < total) {
                maxTotal = total;
            }

            ++endIdx;
        }

        bw.write(String.valueOf(maxTotal));
    }
}
