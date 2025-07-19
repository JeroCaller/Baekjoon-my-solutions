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
        final int K = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i <= N; ++i) {
            if (K >= getMaxPrimeFactor(i)) {
                ++answer;
            }
        }

        bw.write(String.valueOf(answer));
    }

    private static int getMaxPrimeFactor(int n) {
        int max = 1;

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            while (n % i == 0) {
                if (i > max) {
                    max = i;
                }
                n /= i;
            }
        }

        if (n > max) {
            max = n;
        }
        return max;
    }
}
