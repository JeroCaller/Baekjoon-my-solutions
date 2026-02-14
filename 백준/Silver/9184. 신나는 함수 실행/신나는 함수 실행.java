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

    private static final Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        int[] abc = new int[3];

        while (true) {
            String[] inputs = br.readLine().split(" ");

            for (int i = 0; i < 3; ++i) {
                abc[i] = Integer.parseInt(inputs[i]);
            }

            if (abc[0] == -1 && abc[1] == -1 && abc[2] == -1) break;

            int result = w(abc[0], abc[1], abc[2]);
            bw.write(String.format("w(%d, %d, %d) = %d", abc[0], abc[1], abc[2], result));
            bw.newLine();
        }
    }

    private static int w(int a, int b, int c) {
        String key = makeIntoKey(a, b, c);
        int result;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            dp.put(key, 1);
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            result = w(20, 20, 20);
            dp.put(key, result);
            return result;
        }

        if (a < b && b < c) {
            result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            dp.put(key, result);
            return result;
        }

        result = w(a - 1, b, c) + w(a - 1, b - 1, c)
            + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        dp.put(key, result);
        return result;
    }

    private static String makeIntoKey(int a, int b, int c) {
        return String.format("%d,%d,%d", a, b, c);
    }
}
