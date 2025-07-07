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

    private static final List<Long> memo = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        memo.add(0L);
        memo.add(1L);

        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(fibonacci(n)));
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0L;
        }

        if (n == 1) {
            return 1L;
        }

        if (n < memo.size()) {
            return memo.get(n);
        }

        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.add(result);
        return result;
    }
}