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
        final int N = 9;
        int[] numbers = new int[N];
        boolean[] isDwarf = new boolean[N];
        Arrays.fill(isDwarf, true);

        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        outerLoop: for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int total = 0;
                for (int k = 0; k < N; ++k) {
                    if (k == i || k == j) continue;
                    total += numbers[k];
                }
                if (total == 100) {
                    isDwarf[i] = false;
                    isDwarf[j] = false;
                    break outerLoop;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            if (isDwarf[i]) {
                bw.write(String.valueOf(numbers[i]));
                bw.newLine();
            }
        }
    }

}