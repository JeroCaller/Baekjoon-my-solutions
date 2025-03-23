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
        List<Integer> burgerPrices = getListFromInput(3);
        List<Integer> beveragePrices = getListFromInput(2);

        int burgerMinPrice = getMinPrice(burgerPrices);
        int beverageMinPrice = getMinPrice(beveragePrices);

        int result = burgerMinPrice + beverageMinPrice - 50;
        bw.write(String.valueOf(result));
    }

    public static List<Integer> getListFromInput(int count) throws IOException {
        List<Integer> prices = new ArrayList<>();
        for (int i = 1; i <= count; ++i) {
            prices.add(Integer.parseInt(br.readLine()));
        }
        return prices;
    }

    public static int getMinPrice(List<Integer> prices) {
        return prices.stream()
            .min((a, b) -> (a - b))
            .get();
    }

}
