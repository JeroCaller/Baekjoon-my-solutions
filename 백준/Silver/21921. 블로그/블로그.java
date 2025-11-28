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
        final int X = Integer.parseInt(firstLine[1]);
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] visitorsList = new int[N];

        for (int i = 0; i < N; ++i) {
            visitorsList[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxVisitors = 0;
        int numOfMaxVisitors = 0;
        int visitors = 0;

        for (int i = 0; i + X - 1 < N; ++i) {
            int endIdx = i + X - 1;

            if (i == 0) {
                for (int j = i; j <= endIdx; ++j) {
                    visitors += visitorsList[j];
                }
            } else {
                visitors -= visitorsList[i - 1];
                visitors += visitorsList[endIdx];
            }

            if (maxVisitors == visitors) {
                ++numOfMaxVisitors;
            } else if (maxVisitors < visitors) {
                maxVisitors = visitors;
                numOfMaxVisitors = 1;
            }
        }

        if (maxVisitors == 0) {
            bw.write("SAD");
            return;
        }

        bw.write(String.valueOf(maxVisitors));
        bw.newLine();
        bw.write(String.valueOf(numOfMaxVisitors));
    }
}
