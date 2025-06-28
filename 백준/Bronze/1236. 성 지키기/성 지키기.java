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
        String[] nm = br.readLine().split(" ");
        final int N = Integer.parseInt(nm[0]);
        final int M = Integer.parseInt(nm[1]);
        String[] rows = new String[N];

        for (int i = 0; i < N; ++i) {
            rows[i] = br.readLine();
        }

        int answer = 0;
        int maxColumnAtCrossLine = -1;

        // scan rows
        for (int i = 0; i < N; ++i) {
            if (rows[i].contains("X")) {
                continue;
            }

            // scan if there is a intersection in the empty row
            crossColumn: for (int j = 0; j < M; ++j) {
                if (j <= maxColumnAtCrossLine) {
                    continue;
                }

                // scan columns
                for (int k = 0; k < N; ++k) {
                    if (rows[k].charAt(j) == 'X') {
                        continue crossColumn;
                    }
                }

                // mark point at intersection
                maxColumnAtCrossLine = j;
                break; // find only first intersection
            }
            
            ++answer;
        }

        if (maxColumnAtCrossLine == M - 1) {
            bw.write(String.valueOf(answer));
            return;
        }

        // scan columns
        outerLoop: for (int i = maxColumnAtCrossLine + 1; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (rows[j].charAt(i) == 'X') {
                   continue outerLoop;
                }
            }

            ++answer;
        }

        bw.write(String.valueOf(answer));
    }
}