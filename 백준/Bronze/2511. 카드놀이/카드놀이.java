import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
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
        StringTokenizer aToken = new StringTokenizer(br.readLine(), " ");
        StringTokenizer bToken = new StringTokenizer(br.readLine(), " ");
        Stack<Character> whoWin = new Stack<>();

        final int A_IDX = 0;
        final int B_IDX = 1;
        int[] scores = {0, 0};

        while (aToken.hasMoreTokens() && bToken.hasMoreTokens()) {
            int aNumber = Integer.parseInt(aToken.nextToken());
            int bNumber = Integer.parseInt(bToken.nextToken());

            if (aNumber > bNumber) {
                scores[A_IDX] += 3;
                whoWin.push('A');
            } else if (aNumber < bNumber) {
                scores[B_IDX] += 3;
                whoWin.push('B');
            } else {
                ++scores[A_IDX];
                ++scores[B_IDX];
                whoWin.push('D');
            }
        }

        char winner = 'D';
        if (scores[A_IDX] > scores[B_IDX]) {
            winner = 'A';
        } else if (scores[A_IDX] < scores[B_IDX]) {
            winner = 'B';
        } else {
            while (!whoWin.isEmpty()) {
                char who = whoWin.pop();
                if (who != 'D') {
                    winner = who;
                    break;
                }
            }
        }

        for (int score : scores) {
            bw.write(score + " ");
        }
        bw.newLine();
        bw.write(winner);
    }
}