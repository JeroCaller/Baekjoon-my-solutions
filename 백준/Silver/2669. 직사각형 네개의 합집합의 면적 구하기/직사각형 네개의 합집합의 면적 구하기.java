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
        boolean[][] cells = new boolean[100][100];

        for (int i = 0; i < 4; ++i) {
            int[] points = new int[4];
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 4; ++j) {
                points[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int y = points[1]; y < points[3]; ++y) {
                for (int x = points[0]; x < points[2]; ++x) {
                    if (!cells[y][x]) {
                        cells[y][x] = true;
                    }
                }
            }
        }

        int answer = 0;

        for (int y = 0; y < 100; ++y) {
            for (int x = 0; x < 100; ++x) {
                if (cells[y][x]) {
                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}
