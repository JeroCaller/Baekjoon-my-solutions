import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int result = getNumOfPrimes(n, 2 * n);
            bw.write(String.valueOf(result));
            bw.newLine();
        }
    }

    private static int getNumOfPrimes(int startNum, int endNum) {
        ++startNum;
        List<Integer> basePrimes = getPrimes((int) Math.sqrt(endNum));
        int length = endNum - startNum + 1;
        boolean[] isPrime = new boolean[length];
        Arrays.fill(isPrime, true);

        for (int p : basePrimes) {
            int initNum = Math.max(p * p, (startNum + p - 1) / p * p);

            for (int i = initNum; i <= endNum; i += p) {
                isPrime[i - startNum] = false;
            }
        }

        int count = 0;

        for (int i = 0; i < length; ++i) {
            if (isPrime[i]) {
                ++count;
            }
        }

        return count;
    }

    private static List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}

