import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] isNotPrimeArray;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int M = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());

        setIsNotPrimeArray(N);

        List<Integer> primes = new ArrayList<>();
        for (int k = M; k <= N; ++k) {
            if (!isNotPrimeArray[k]) {
                primes.add(k);
            }
        }

        if (primes.isEmpty()) {
            bw.write(String.valueOf(-1));
            return;
        }

        int total = 0;
        for (int number : primes) {
            total += number;
        }

        bw.write(String.valueOf(total));
        bw.newLine();
        bw.write(String.valueOf(primes.get(0)));
    }

    public static void setIsNotPrimeArray(int n) {
        isNotPrimeArray = new boolean[n + 1];
        isNotPrimeArray[0] = true;
        isNotPrimeArray[1] = true;

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (isNotPrimeArray[i]) {
                continue;
            }

            for (int j = i * i; j < isNotPrimeArray.length; j = j + i) {
                isNotPrimeArray[j] = true;
            }
        }
    }
}