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

    private static final int M = 10;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            String[] input = br.readLine().split(" ");
            int[] ab = new int[input.length];
            for (int j = 0; j < input.length; ++j) {
                ab[j] = Integer.parseInt(input[j]);
            }

            bw.write(String.valueOf(mod(ab[0], ab[1])));
            bw.newLine();
        }
    }

    public static int mod(int a, int b) {
        int result = 1;
        int currentBase = a % M;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * currentBase) % M;
            }
            currentBase = (currentBase * currentBase) % M;
            b /= 2;
        }
        if (result == 0) {
            return 10;
        }
        return result;
    }
}