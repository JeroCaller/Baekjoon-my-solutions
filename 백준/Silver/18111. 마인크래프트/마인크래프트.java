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
        String[] conditions = br.readLine().split(" ");
        final int N = Integer.parseInt(conditions[0]);
        final int M = Integer.parseInt(conditions[1]);
        final int B = Integer.parseInt(conditions[2]);
        int[][] ground = new int[N][M];
        int minHeight = 256;
        int maxHeight = 0;

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; ++j) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, ground[i][j]);
                maxHeight = Math.max(maxHeight, ground[i][j]);
            }
        }

        int minTime = -1;
        int maxGroundHeight = 0;

        for (int targetHeight = minHeight; targetHeight <= maxHeight; ++targetHeight) {
            int costTime = 0;
            int inventory = B;

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    int diff = targetHeight - ground[i][j];
                    if (diff == 0) continue;

                    if (diff > 0) {
                        inventory -= diff;
                        costTime += diff;
                    } else {
                        diff = Math.abs(diff);
                        inventory += diff;
                        costTime += diff * 2;
                    }
                }
            }

            if (inventory < 0) {
                continue;
            }

            if (minTime == -1 || minTime > costTime) {
                minTime = costTime;
                maxGroundHeight = targetHeight;
            } else if (minTime == costTime) {
                maxGroundHeight = Math.max(maxGroundHeight, targetHeight);
            }
        }

        bw.write(String.format("%d %d", minTime, maxGroundHeight));
    }
}
