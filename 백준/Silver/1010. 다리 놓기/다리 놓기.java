import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final List<BigInteger> memo =
        new ArrayList<>(Arrays.asList(BigInteger.ONE, BigInteger.ONE));

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            bw.write(String.valueOf(getComb(m, n)));
            bw.newLine();
        }
    }

    public static BigInteger getComb(int m, int n) {
        return factorialBig(m).divide(factorialBig(m - n).multiply(factorialBig(n)));
    }

    private static BigInteger factorialBig(int n) {
        if (n < memo.size()) {
            return memo.get(n);
        }

        BigInteger result = factorialBig(n - 1).multiply(BigInteger.valueOf(n));
        memo.add(result);
        return result;
    }
}