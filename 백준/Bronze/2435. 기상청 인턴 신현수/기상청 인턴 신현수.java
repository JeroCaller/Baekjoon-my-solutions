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
        String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int K = Integer.parseInt(inputs[1]);
        int[] temps = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            temps[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i + K <= N; ++i) {
            int total = 0;
            for (int j = i; j < i + K; ++j) {
                total += temps[j];
            }
            if (max < total) {
                max = total;
            }
        }

        bw.write(String.valueOf(max));
    }
}