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
        final int L = Integer.parseInt(firstLine[1]);
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] pos = new int[N];

        for (int i = 0; i < N; ++i) {
            pos[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(pos);

        int startIdx = 0;
        int endIdx = 0;
        int answer = 0;

        while (startIdx < N && endIdx < N) {
            int diff = pos[endIdx] - pos[startIdx] + 1;

            if (diff < L) {
                ++endIdx;

                if (endIdx >= N) {
                    ++answer;
                }
            } else if (diff > L) {
                ++answer;
                startIdx = endIdx;
            } else {
                ++answer;
                startIdx = endIdx + 1;
                endIdx = startIdx;
            }
        }

        bw.write(String.valueOf(answer));
    }
}
