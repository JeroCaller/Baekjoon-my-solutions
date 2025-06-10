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
        final int N = 20;
        int[] cards = new int[N + 1];
        for (int i = 1; i < cards.length; ++i) {
            cards[i] = i;
        }

        final int INTERVALS = 10;
        for (int i = 0; i < INTERVALS; ++i) {
            String[] input = br.readLine().split(" ");
            int[] intervals = new int[2];
            for (int j = 0; j < intervals.length; ++j) {
                intervals[j] = Integer.parseInt(input[j]);
            }

            for (int k = intervals[0]; k <= (intervals[0] + intervals[1]) / 2; ++k) {
                int endIdx = intervals[0] + intervals[1] - k;
                int tempCard = cards[k];
                cards[k] = cards[endIdx];
                cards[endIdx] = tempCard;
            }
        }

        for (int i = 1; i < cards.length; ++i) {
            bw.write(cards[i] + " ");
        }
    }

}