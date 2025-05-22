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
        // Quarter, Dime, Nickel, Penny
        final int[] coinKind = {25, 10, 5, 1};
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            // Quarter, Dime, Nickel, Penny
            int[] numOfCoins = {0, 0, 0, 0};
            int change = Integer.parseInt(br.readLine());
            for (int j = 0; j < coinKind.length; ++j) {
                numOfCoins[j] = change / coinKind[j];
                change = change % coinKind[j];
                if (change == 0) {
                    break;
                }
            }
            for (int numOfCoin : numOfCoins) {
                bw.write(String.valueOf(numOfCoin) + " ");
            }
            bw.newLine();
        }

    }

}