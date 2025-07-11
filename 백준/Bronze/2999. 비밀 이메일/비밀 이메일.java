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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String source = br.readLine();
        final int N = source.length();
        final int R = getNumOfRow(N);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < R; ++i) {
            for (int j = i; j < N; j = j + R) {
                stringBuilder.append(source.charAt(j));
            }
        }

        bw.write(stringBuilder.toString());
    }

    public static int getNumOfRow(int n) {
        List<Integer> divisors = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);
        int max = 1;

        for (int i = 1; i <= sqrt; ++i) {
            if (n % i == 0) {
                divisors.add(i);

                int q = n / i;
                if (!divisors.contains(q)) {
                    divisors.add(q);
                }
            }
        }

        divisors.sort((a, b) -> a - b);
        int idx = 0;
        while (divisors.get(idx) <= sqrt) {
            max = divisors.get(idx);
            ++idx;
        }

        return max;
    }
}