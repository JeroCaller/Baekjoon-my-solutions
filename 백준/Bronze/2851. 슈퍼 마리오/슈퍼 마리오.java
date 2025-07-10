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
        final int N = 10;
        int total = 0;

        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine());
            int nextTotal = total + num;

            if (nextTotal >= 100) {
                int totalDiff = Math.abs(100 - total);
                int nextTotalDiff = Math.abs(nextTotal - 100);

                if (totalDiff == nextTotalDiff) {
                    total = nextTotal;
                } else {
                    total = (totalDiff < nextTotalDiff) ? total : nextTotal;
                }
                break;
            }

            total = nextTotal;
        }

        bw.write(String.valueOf(total));
    }
}