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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        String[] rect = new String[N];
        int answer = 1;

        for (int i = 0; i < N; ++i) {
            rect[i] = br.readLine();
        }

        for (int i = 0; i < N - 1; ++i) {
            for (int j = 0; j < M - 1; ++j) {
                char leftTopChar = rect[i].charAt(j);

                for (int k = 1; k < Math.min(N - i, M - j); ++k) {
                    if (rect[i + k].charAt(j + k) != leftTopChar ||
                        rect[i].charAt(j + k) != leftTopChar ||
                        rect[i + k].charAt(j) != leftTopChar) {
                        continue;
                    }

                    int area = (k + 1) * (k + 1);

                    if (area > answer) {
                        answer = area;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}
