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
        String[] inputs = br.readLine().split(" ");
        final int M = Integer.parseInt(inputs[0]);
        final int N = Integer.parseInt(inputs[1]);
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); ++i) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = 2; i * j <= N; ++j) {
                isNotPrime[i * j] = true;
            }
        }

        for (int i = M; i <= N; ++i) {
            if (!isNotPrime[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
    }
}
