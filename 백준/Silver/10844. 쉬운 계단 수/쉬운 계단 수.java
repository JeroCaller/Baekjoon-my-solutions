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

    private static int n;
    private static long total = 0;
    private static long[][] memo;
    private static final int DIVIDER = 1000000000;
    
    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        memo = new long[10][n + 1];

        for (int i = 0; i < 10; ++i) {
            memo[i][1] = 1;
        }

        for (int i = 1; i < 10; ++i) {
            total += search(i, n);
        }

        bw.write(String.valueOf(total % DIVIDER));
    }

    private static long search(int number, int length) {
        if (number < 0 || number > 9) {
            return 0;
        }

        if (memo[number][length] != 0) {
            return memo[number][length];
        }

        long result = search(number - 1, length - 1) % DIVIDER;
        result += search(number + 1, length - 1) % DIVIDER;
        result %= DIVIDER;
        memo[number][length] = result;
        return memo[number][length];
    }
}
