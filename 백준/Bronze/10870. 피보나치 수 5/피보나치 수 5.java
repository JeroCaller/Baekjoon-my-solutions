import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    // <n, F(n)>
    private static final Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        int input = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(fibo(input)));
    }

    public static int fibo(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n <= 1) {
            memo.put(n, n);
        } else {
            int value = fibo(n - 1) + fibo(n - 2);
            memo.put(n, value);
        }
        return memo.get(n);
    }
}