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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int MAX_PRICE = 1000;
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        int minPackagePrice = MAX_PRICE;
        int minOnePrice = MAX_PRICE;

        for (int i = 0; i < M; ++i) {
            String[] line = br.readLine().split(" ");
            int packagePrice = Integer.parseInt(line[0]);
            int onePrice = Integer.parseInt(line[1]);

            minPackagePrice = Math.min(minPackagePrice, packagePrice);
            minOnePrice = Math.min(minOnePrice, onePrice);
        }

        int q = N / 6;
        int r = N % 6;
        int minPrice = Integer.MAX_VALUE;
        int[] possiblePrices = {
            (r != 0) ? (q + 1) * minPackagePrice : q * minPackagePrice,
            N * minOnePrice,
            q * minPackagePrice + r * minOnePrice
        };

        for (int i = 0; i < possiblePrices.length; ++i) {
            minPrice = Math.min(minPrice, possiblePrices[i]);
        }

        bw.write(String.valueOf(minPrice));

        /*
        bw.newLine();
        bw.write(String.format("%d, %d, %d",
            possiblePrices[0],
            possiblePrices[1],
            possiblePrices[2]
        ));

         */
    }
}
