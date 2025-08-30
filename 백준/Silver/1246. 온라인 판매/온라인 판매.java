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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int M = Integer.parseInt(inputs[1]);

        int[] prices = new int[M];

        for (int i = 0; i < M; ++i) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices);

        int maxTotal = 0;
        int maxPrice = 0;

        for (int i = 0; i < M; ++i) {
            int currentTotal = prices[i] * Math.min(N, M - i);

            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                maxPrice = prices[i];
            }
        }

        bw.write(maxPrice + " " + maxTotal);
    }
}
