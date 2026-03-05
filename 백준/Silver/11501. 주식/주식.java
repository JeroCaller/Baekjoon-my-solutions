import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());
            int[] stocks = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long total = 0;
            long maxPrice = 0;
            long accPrices = 0;
            int countNumOfStocks = 0;

            for (int j = 1; j < stocks.length; ++j) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            maxPrice = stocks[stocks.length - 1];

            for (int j = stocks.length - 2; j >= 0; --j) {
                if (j == 0 || maxPrice < stocks[j]) {
                    total += (countNumOfStocks * maxPrice) - accPrices;
                    maxPrice = stocks[j];
                    accPrices = 0;
                    countNumOfStocks = 0;
                } else {
                    accPrices += stocks[j];
                    countNumOfStocks++;
                }
            }

            bw.write(String.valueOf(total));
            bw.newLine();
        }
    }
}
