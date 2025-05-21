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
        String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int K = Integer.parseInt(inputs[1]);

        int endIndex = (int) Math.sqrt(N);
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= endIndex; ++i) {
            if (N % i == 0) {
                divisors.add(i);

                // 25 / 5 = 5 => 25 [1 5 5 25] => No!
                if (N / i != i) {
                    divisors.add(N / i);
                }
            }
        }
        divisors.sort((a, b) -> a - b);

        int result = 0;
        if (divisors.size() >= K) {
            result = divisors.get(K - 1);
        }
        bw.write(String.valueOf(result));
    }

}
