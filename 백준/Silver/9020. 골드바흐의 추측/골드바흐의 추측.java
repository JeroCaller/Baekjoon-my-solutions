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

    private static final int N = 10000;
    private static final boolean[] isPrime = new boolean[N + 1];

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int T = Integer.parseInt(br.readLine());
        filterPrimeNumbers();

        for (int i = 0; i < T; ++i) {
            int num = Integer.parseInt(br.readLine());
            int[] partitions = new int[2];

            for (int j = 1; j <= num / 2; ++j) {
                int smallNum = j;
                int largeNum = num - j;

                if (!isPrime[smallNum] || !isPrime[largeNum]) {
                    continue;
                }

                if ((partitions[0] == 0 && partitions[1] == 0) ||
                    (partitions[1] - partitions[0] > largeNum - smallNum)) {
                    partitions[0] = smallNum;
                    partitions[1] = largeNum;
                }
            }

            bw.write(String.format("%d %d", partitions[0], partitions[1]));
            bw.newLine();
        }
    }

    private static void filterPrimeNumbers() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
