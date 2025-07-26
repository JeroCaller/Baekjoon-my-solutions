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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        int[][] numbers = new int[N][M];

        // O(NM)
        for (int i = 0; i < N; ++i) { // O(N)
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; ++j) { // O(M)
                numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        final int K = Integer.parseInt(br.readLine());
        int[][] indices = new int[K][4];

        // O(K)
        for (int i = 0; i < K; ++i) { // O(K)
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 4; ++j) {
                indices[i][j] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            }
        }

        // O(NMK)
        for (int i = 0; i < K; ++i) {  // O(K)
            int total = 0;

            // O(NM)
            for (int x = indices[i][0]; x <= indices[i][2]; ++x) {  // O(N)
                for (int y = indices[i][1]; y <= indices[i][3]; ++y) {  // O(M)
                    total += numbers[x][y];
                }
            }

            bw.write(String.valueOf(total));
            bw.newLine();
        }
    }
}
