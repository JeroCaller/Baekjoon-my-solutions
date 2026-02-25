import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n, m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        processInput();
        int answer = getAnswer();
        bw.write(String.valueOf(answer));
    }

    private static void processInput() throws IOException {
        String[] conditions = br.readLine().split(" ");
        n = Integer.parseInt(conditions[0]);
        m = Integer.parseInt(conditions[1]);
        map = new int[n][m];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int getAnswer() {
        int[][] memo = new int[n][m];
        memo[0][0] = map[0][0];

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                int[][] nextIdxs = {{r + 1, c}, {r, c + 1}, {r + 1, c + 1}};

                for (int[] nextIdx : nextIdxs) {
                    if (nextIdx[0] >= n || nextIdx[1] >= m) {
                        continue;
                    }

                    memo[nextIdx[0]][nextIdx[1]] = Math.max(
                        memo[nextIdx[0]][nextIdx[1]],
                        memo[r][c] + map[nextIdx[0]][nextIdx[1]]
                    );
                }
            }
        }

        return memo[n - 1][m - 1];
    }
}
