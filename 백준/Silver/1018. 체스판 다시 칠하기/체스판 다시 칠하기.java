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
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        String[] board = new String[N];

        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine();
        }

        int answer = Integer.MAX_VALUE;
        for (int startRow = 0; startRow <= N - 8; ++startRow) {
            for (int startCol = 0; startCol <= M - 8; ++startCol) {
                int numOfChangeWithWStart = 0;

                for (int r = startRow; r < startRow + 8; ++r) {
                    for (int c = startCol; c < startCol + 8; ++c) {
                        if ((r + c) % 2 == 0 && board[r].charAt(c) == 'B') {
                            ++numOfChangeWithWStart;
                        } else if ((r + c) % 2 == 1 && board[r].charAt(c) == 'W') {
                            ++numOfChangeWithWStart;
                        }
                    }
                }

                int thisNum = Math.min(numOfChangeWithWStart, 64 - numOfChangeWithWStart);
                if (answer > thisNum) {
                    answer = thisNum;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}
