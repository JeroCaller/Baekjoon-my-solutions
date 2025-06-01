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
        int balance = 1000 - Integer.parseInt(br.readLine());
        int[] kindOfCoins = {500, 100, 50, 10, 5, 1};
        int count = 0;
        for (int coin : kindOfCoins) {
            int theNumberOfCoin = balance / coin;
            if (theNumberOfCoin > 0) {
                balance -= coin * theNumberOfCoin;
                count += theNumberOfCoin;
            }
        }
        bw.write(String.valueOf(count));
    }
}