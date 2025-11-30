import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
        int[] ranks = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            ranks[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ranks);

        long answer = 0;

        for (int i = 1; i <= N; ++i) {
            answer += Math.abs(ranks[i] - i);
        }

        bw.write(String.valueOf(answer));
    }
}
