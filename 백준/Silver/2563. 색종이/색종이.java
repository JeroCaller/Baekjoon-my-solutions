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
        final int N = Integer.parseInt(br.readLine());
        boolean[][] area = new boolean[100][100];

        for (int i = 0; i < N; ++i) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            for (int j = y; j < y + 10; ++j) {
                for (int k = x; k < x + 10; ++k) {
                    if (!area[j][k]) {
                        area[j][k] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                if (area[i][j]) {
                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }

}
