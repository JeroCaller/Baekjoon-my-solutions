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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        int[][] a = getMatrix();
        int[][] b =  getMatrix();
        final int R = a.length;
        final int C = b[0].length;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                int value = 0;

                for (int k = 0; k < a[0].length; ++k) {
                    value += a[i][k] * b[k][j];
                }

                stringBuilder.append(value).append(" ");
            }

            stringBuilder.append("\n");
        }

        bw.write(stringBuilder.toString().trim());
    }

    private static int[][] getMatrix() throws IOException {
        String[] condition = br.readLine().split(" ");
        final int R = Integer.parseInt(condition[0]);
        final int C = Integer.parseInt(condition[1]);
        int[][] matrix = new int[R][C];

        for (int i = 0; i < R; ++i) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < C; ++j) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        return matrix;
    }
}
