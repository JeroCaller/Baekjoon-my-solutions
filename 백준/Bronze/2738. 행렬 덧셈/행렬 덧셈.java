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
        final int[] metaData = getNums(br.readLine().split(" "));
        final int N = metaData[0];
        final int M = metaData[1];

        final int[][][] matrices = new int[2][N][M];
        final int[][] results = new int[N][M];

        // initializing
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < N; ++j) {
                matrices[i][j] = getNums(br.readLine().split(" "));
            }
        }

        // adding
        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < M; ++y) {
                results[x][y] = matrices[0][x][y] + matrices[1][x][y];
            }
        }

        // printing
        for (int a = 0; a < N; ++a) {
            for (int b = 0; b < M; ++b) {
                bw.write(results[a][b] + " ");
            }
            bw.newLine();
        }

    }

    public static int[] getNums(String[] oneLine) {
        int[] nums = new int[oneLine.length];
        for (int i = 0; i < oneLine.length; ++i) {
            nums[i] = Integer.parseInt(oneLine[i]);
        }
        return nums;
    }

}
