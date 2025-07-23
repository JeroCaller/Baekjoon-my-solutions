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
        int[][] paints = new int[101][101];
        String[] conditions = br.readLine().split(" ");
        final int N = Integer.parseInt(conditions[0]);
        final int M = Integer.parseInt(conditions[1]);

        for (int i = 0; i < N; ++i) {
            String[] coords = br.readLine().split(" ");
            int xl = Integer.parseInt(coords[0]);
            int yl = Integer.parseInt(coords[1]);
            int xr = Integer.parseInt(coords[2]);
            int yr = Integer.parseInt(coords[3]);

            for (int y = yl; y <= yr; ++y) {
                for (int x = xl; x <= xr; ++x) {
                    ++paints[y][x];
                }
            }
        }

        int answer = 0;
        for (int y = 1; y <= 100; ++y) {
            for (int x = 1; x <= 100; ++x) {
                if (paints[y][x] > M) {
                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}
