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

    private static final int LIMIT = 1000000;
    private static final boolean[] isNotPrime = new boolean[LIMIT + 1];
    private static int numOfPrimes = LIMIT - 2;
    private static int[] primes;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int T = Integer.parseInt(br.readLine());
        checkIfPrime();
        makePrimeArray();

        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());
            int count = getAnswer(n);
            bw.write(String.valueOf(count));
            bw.newLine();
        }
    }

    private static void checkIfPrime() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= LIMIT; ++i) {
            if (isNotPrime[i]) {
                --numOfPrimes;
                continue;
            }

            for (int j = i * i; j <= LIMIT; j += i) {
                if (isNotPrime[j]) {
                    continue;
                }

                isNotPrime[j] = true;
                --numOfPrimes;
            }
        }
    }

    private static void makePrimeArray() {
        primes = new int[numOfPrimes];
        int idx = 0;

        for (int i = 2; i < isNotPrime.length; ++i) {
            if (isNotPrime[i]) {
                continue;
            }

            if (idx >= numOfPrimes) {
                break;
            }

            primes[idx++] = i;
        }
    }

    private static int getAnswer(int n) {
        int count = 0;

        for (int prime : primes) {
            if (prime > n / 2) {
                break;
            }

            if (!isNotPrime[n - prime]) {
                ++count;
            }
        }

        return count;
    }
}
