import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
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
        final int CARDS = 5;
        final int N = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            int cardNumDiff = p2.getCardNumber() - p1.getCardNumber();

            if (cardNumDiff != 0) {
                return cardNumDiff;
            }

            return p2.getPersonNumber() - p1.getPersonNumber();
        });

        for (int i = 0; i < N; ++i) {
            int[] cards = new int[CARDS];
            int currentHighNumber = 0;
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < CARDS; ++j) {
                cards[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            // indices to discard
            int startIdx = 0;
            int endIdx = 1;

            while (startIdx < CARDS - 1) {
                if (currentHighNumber == 9) {
                    break;
                }

                int total = 0;

                for (int j = 0; j < CARDS; ++j) {
                    if (j == startIdx || j == endIdx) {
                        continue;
                    }

                    total += cards[j];
                }

                char[] totalChars = String.valueOf(total).toCharArray();
                int endNumber = totalChars[totalChars.length - 1] - '0';

                if (currentHighNumber < endNumber) {
                    currentHighNumber = endNumber;
                }

                if (endIdx < CARDS - 1) {
                    ++endIdx;
                } else {
                    ++startIdx;
                    endIdx = startIdx + 1;
                }
            }

            Pair pair = new Pair();
            pair.setPersonNumber(i);
            pair.setCardNumber(currentHighNumber);

            pq.offer(pair);
        }

        bw.write(String.valueOf(pq.peek().getPersonNumber() + 1));

        /*
        bw.newLine();
        bw.write(pq.toString());
         */
    }
}

class Pair {
    private int personNumber;
    private int cardNumber;

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /*
    @Override
    public String toString() {
        return String.format("%d번: %d", personNumber + 1, cardNumber);
    }
     */
}