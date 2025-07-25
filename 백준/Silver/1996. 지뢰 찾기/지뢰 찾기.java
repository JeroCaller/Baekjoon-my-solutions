import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
        char[][] answer = new char[N][N];
        String[] inputs = new String[N];

        for (int i = 0; i < N; ++i) {
            inputs[i] = br.readLine();
            Arrays.fill(answer[i], '0');
        }

        if (N == 1) {
            char ans = (inputs[0].charAt(0) == '.') ? '0' : '*';
            bw.write(String.valueOf(ans));
            return;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                char currentChar = inputs[i].charAt(j);
                if (currentChar == '.') {
                    continue;
                }

                answer[i][j] = '*';

                int[] rangeX = decideRange(j, N);
                int[] rangeY = decideRange(i, N);

                for (int y = rangeY[0]; y <= rangeY[1]; ++y) {
                    for (int x = rangeX[0]; x <= rangeX[1]; ++x) {
                        if (answer[y][x] == '*' || answer[y][x] == 'M') {
                            continue;
                        }

                        if (toInt(answer[y][x]) + toInt(currentChar) > 9) {
                            answer[y][x] = 'M';
                        } else {
                            answer[y][x] = (char) (toInt(answer[y][x]) + toInt(currentChar) + '0');
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                bw.write(String.valueOf(answer[i][j]));
            }
            bw.newLine();
        }
    }

    private static int[] decideRange(int currentPos, int n) {
        // start, end
        int[] range = new int[2];

        if (currentPos == n - 1) {
            range[0] = currentPos - 1;
            range[1] = currentPos;
        } else if (currentPos == 0) {
            range[1] = currentPos + 1;
        } else {
            range[0] = currentPos - 1;
            range[1] = currentPos + 1;
        }

        return range;
    }

    private static int toInt(char numChar) {
        if ('0' <= numChar && numChar <= '9') {
            return numChar - '0';
        }
        return numChar;
    }
}
