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
        final int M = Integer.parseInt(firstLine[1]);
        int[] numbers = new int[N + 1];
        int[] totals = new int[N + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; ++i) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            totals[i] = numbers[i] + totals[i - 1];
        }

        for (int i = 0; i < M; ++i) {
            String[] oneLine = br.readLine().split(" ");
            int leftIdx = Integer.parseInt(oneLine[0]);
            int rightIdx = Integer.parseInt(oneLine[1]);

            bw.write(String.valueOf(totals[rightIdx] - totals[leftIdx - 1]));
            bw.newLine();
        }
    }
}
