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

    private static final int[][][] memo = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        while (true) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            if (a == -1 && b == -1 && c == -1) break;

            int result = w(a, b, c);
            bw.write(String.format("w(%d, %d, %d) = %d", a, b, c, result));
            bw.newLine();
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (memo[a][b][c] != 0) {
            return memo[a][b][c];
        }

        int result;

        if (a < b && b < c) {
            result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            memo[a][b][c] = result;
            return result;
        }

        result = w(a - 1, b, c) + w(a - 1, b - 1, c) +
            w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        memo[a][b][c] = result;
        return result;
    }
}
