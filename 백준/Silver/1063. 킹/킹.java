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
        String[] firstLine = br.readLine().split(" ");
        char[] king = new char[2];
        char[] stone = new char[2];
        final int N = Integer.parseInt(firstLine[2]);

        for (int i = 0; i < 2; ++i) {
            king[i] = firstLine[0].charAt(i);
            stone[i] = firstLine[1].charAt(i);
        }

        String input = null;
        String command = null;
        char[] kingMovesTo;
        char[] stoneMovesTo;

        for (int i = 0; i < N; ++i) {
            stoneMovesTo = null;
            input = br.readLine();
            kingMovesTo = getNextStep(king, input);

            if (!isInsideBoard(kingMovesTo)) {
                continue;
            }

            if (kingMovesTo[0] == stone[0] && kingMovesTo[1] == stone[1]) {
                command = getCommand(king, stone);
                stoneMovesTo = getNextStep(stone, command);

                if (!isInsideBoard(stoneMovesTo)) {
                    continue;
                }
            }

            for (int j = 0; j < 2; ++j) {
                king[j] = kingMovesTo[j];

                if (stoneMovesTo != null) {
                    stone[j] = stoneMovesTo[j];
                }
            }
        }

        for (int i = 0; i < 2; ++i) {
            bw.write(king[i]);
        }

        bw.newLine();

        for (int i = 0; i < 2; ++i) {
            bw.write(stone[i]);
        }
    }

    private static char[] getNextStep(char[] original, String input) {
        char[] nextStep = {original[0], original[1]};

        switch (input) {
            case "R":
                ++nextStep[0];
                break;
            case "L":
                --nextStep[0];
                break;
            case "B":
                --nextStep[1];
                break;
            case "T":
                ++nextStep[1];
                break;
            case "RT":
                ++nextStep[0];
                ++nextStep[1];
                break;
            case "LT":
                --nextStep[0];
                ++nextStep[1];
                break;
            case "RB":
                ++nextStep[0];
                --nextStep[1];
                break;
            case "LB":
                --nextStep[0];
                --nextStep[1];
                break;
        }

        return nextStep;
    }

    private static boolean isInsideBoard(char[] coords) {
        return ('A' <= coords[0] && coords[0] <= 'H') &&
            ('1' <= coords[1] && coords[1] <= '8');
    }

    private static String getCommand(char[] king, char[] stone) {
        String command;

        int diffRow = stone[1] - king[1];
        int diffCol = stone[0] - king[0];

        if (Math.abs(diffRow) > 1 || Math.abs(diffCol) > 1) {
            return null;
        }

        if (diffRow == 1) {
            if (diffCol == -1) {
                return "LT";
            } else if (diffCol == 1) {
                return "RT";
            }
            return "T";
        } else if (diffRow == -1) {
            if (diffCol == -1) {
                return "LB";
            } else if (diffCol == 1) {
                return "RB";
            }
            return "B";
        } else {
            if (diffCol == -1) {
                return "L";
            }
            return "R";
        }
    }
}
