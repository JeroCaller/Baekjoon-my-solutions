import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

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
        final int N = Integer.parseInt(br.readLine());

        // candidates, score counts
        // -1 : garbage
        int[][] candidates = {
            {-1, -1, -1, -1},
            {-1, 0, 0, 0},
            {-1, 0, 0, 0},
            {-1, 0, 0, 0}
        };

        for (int i = 0; i < N; ++i) {
            String[] inputs = br.readLine().split(" ");

            for (int j = 0; j < 3; ++j) {
                int score = Integer.parseInt(inputs[j]);
                ++candidates[j + 1][score];
            }
        }

        int[] totalScores = {-1, 0, 0, 0};
        for (int i = 1; i <= 3; ++i) {
            for (int j = 1; j <= 3; ++j) {
                totalScores[i] += j * candidates[i][j];
            }
        }

        // candidate number, total score
        Stack<Map.Entry<Integer, Integer>> winners = new Stack<>();
        winners.push(new AbstractMap.SimpleEntry<>(-1, -1));
        for (int i = 1; i <= 3; ++i) {
            if (winners.peek().getValue() <= totalScores[i]) {
                winners.push(new AbstractMap.SimpleEntry<>(i, totalScores[i]));
            }
        }
        winners.remove(0);

        /*
        // test
        bw.write("winner stack: " + winners);
        bw.newLine();
        bw.write("All Scores");
        bw.newLine();
        for (int i = 1; i <= 3; ++i) {
            for (int j = 1; j <= 3; ++j) {
                bw.write(candidates[i][j] + " ");
            }
            bw.newLine();
        }
        bw.write("===========");
        bw.newLine();
        // test end

         */

        if (skipAdditionalJudge(winners)) {
            Map.Entry<Integer, Integer> oneWinner = winners.pop();
            bw.write(String.format("%d %d", oneWinner.getKey(), oneWinner.getValue()));
            return;
        }

        // candidates, score count
        Stack<Map.Entry<Integer, Integer>> winnersWithCount = new Stack<>();
        for (int targetScore = 3; targetScore > 1; --targetScore) {
            winnersWithCount.push(new AbstractMap.SimpleEntry<>(-1, -1));

            for (Map.Entry<Integer, Integer> winner : winners) {
                int candidateNumber = winner.getKey();
                int scoreCount = candidates[candidateNumber][targetScore];
                if (winnersWithCount.peek().getValue() <= scoreCount) {
                    winnersWithCount.push(
                        new AbstractMap.SimpleEntry<>(candidateNumber, scoreCount)
                    );
                }
            }
            winnersWithCount.remove(0);

            if (skipAdditionalJudge(winnersWithCount)) {
                int candidateNumber = winnersWithCount.peek().getKey();
                bw.write(String.format("%d %d", candidateNumber, totalScores[candidateNumber]));
                return;
            }

            winnersWithCount.clear();
        }

        Map.Entry<Integer, Integer> oneWinner = winners.pop();
        bw.write(String.format("%d %d", 0, oneWinner.getValue()));
    }

    public static boolean skipAdditionalJudge(Stack<Map.Entry<Integer, Integer>> stack) {
        int maxValue = stack.peek().getValue();
        for (int i = 0; i < stack.size() - 1; ++i) {
            if (maxValue == stack.get(i).getValue()) {
                return false;
            }
        }
        return true;
    }
}