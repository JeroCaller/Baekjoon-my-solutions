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
        final int N = Integer.parseInt(inputs[0]);
        final int L = Integer.parseInt(inputs[1]);
        final int LIMIT_LENGTH = 100;

        for (int i = L; i <= LIMIT_LENGTH; ++i) {
            int numerator = 2 * N - i * (i - 1);
            int denominator = 2 * i;
            int x = numerator / denominator;

            if (numerator % denominator != 0 || x < 0) {
                continue;
            }

            for (int j = x; j < x + i; ++j) {
                bw.write(j + " ");
            }

            return;
        }

        bw.write("-1");
    }
}
