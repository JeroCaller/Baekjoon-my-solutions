import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        final int yourScore = Integer.parseInt(firstLine[1]);
        final int P = Integer.parseInt(firstLine[2]);

        if (N == 0) {
            bw.write("1");
            return;
        }

        int[] rankScores = new int[P];
        Arrays.fill(rankScores, -1);

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            rankScores[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int sameScoreIdx = -1;

        for (int i = 0; i < P; ++i) {
            if (rankScores[i] == yourScore) {
                if (sameScoreIdx == -1 || rankScores[sameScoreIdx] != yourScore) {
                    sameScoreIdx = i;
                }
            } else if (rankScores[i] < yourScore) {
                if (sameScoreIdx >= 0 && rankScores[sameScoreIdx] == yourScore) {
                    bw.write(String.valueOf(sameScoreIdx + 1));
                } else {
                    bw.write(String.valueOf(i + 1));
                }
                return;
            }
        }

        bw.write("-1");
    }
}
