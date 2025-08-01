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
        int answer = 0;

        outer: for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                if (i + j >= N) {
                    break outer;
                }

                int k = N - i - j;

                if (j > k) {
                    break;
                }

                if (i + j > k) {
                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}
