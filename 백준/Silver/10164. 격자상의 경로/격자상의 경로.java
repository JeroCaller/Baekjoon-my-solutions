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

    private static int n, m, k;
    private static int[][] table;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        table = new int[n][m];
        table[0][0] = 1;
        int[] midPos = new int[2];
        int q = k / m;
        int r = k % m;

        if (q != 0 || r != 0) {
            if (r == 0) {
                midPos[0] = q - 1;
                midPos[1] = m - 1;
            } else {
                midPos[0] = q;
                midPos[1] = r - 1;
            }
        }

        if (midPos[0] == 0 && midPos[1] == 0) {
            search(new int[]{0, 0}, new int[]{n - 1, m - 1});
        } else {
            search(new int[]{0, 0}, midPos);
            search(midPos, new int[]{n - 1, m - 1});
        }

        bw.write(String.valueOf(table[n - 1][m - 1]));
    }

    private static void search(int[] startPos, int[] endPos) {
        for (int i = startPos[0]; i <= endPos[0]; ++i) {
            for (int j = startPos[1]; j <= endPos[1]; ++j) {
                if (i == startPos[0] && j == startPos[1]) {
                    continue;
                }

                int[][] adjPositions = {{i, j - 1}, {i - 1, j}};

                for (int[] adjPos : adjPositions) {
                    if (adjPos[0] < 0 || adjPos[0] >= n || adjPos[1] < 0 || adjPos[1] >= m) {
                        continue;
                    }

                    table[i][j] += table[adjPos[0]][adjPos[1]];
                }
            }
        }
    }
}
