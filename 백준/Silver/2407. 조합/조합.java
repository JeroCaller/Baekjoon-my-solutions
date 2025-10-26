import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final BigInteger[] memo = new BigInteger[101];

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        BigInteger numerator = factorial(N);
        BigInteger denominator = factorial(N - M).multiply(factorial(M));
        BigInteger result = numerator.divide(denominator);

        bw.write(result.toString());
    }

    private static BigInteger factorial(int n) {
        if (n <= 1) {
            if (memo[n] == null) {
                memo[n] = BigInteger.ONE;
            }

            return memo[n];
        }

        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = BigInteger.valueOf(n).multiply(factorial(n - 1));
        return memo[n];
    }
}
