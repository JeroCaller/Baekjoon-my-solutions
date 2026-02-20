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

    private static byte[][] papers;
    private static int n;
    private static final int[] counters = new int[3];  // -1, 0, 1

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        papers = new byte[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; ++j) {
                papers[i][j] = Byte.parseByte(st.nextToken());
            }
        }

        calculate(0, 0, n);

        for (int num : counters) {
            bw.write(String.valueOf(num));
            bw.newLine();
        }
    }

    private static void calculate(int x, int y, int length) {
        Byte number = check(x, y, length);

        if (number != null) {
            counters[number + 1]++;
            return;
        }

        int nextL = length / 3;

        for (int nextY = y; nextY < y + length; nextY += nextL) {
            for (int nextX = x; nextX < x + length; nextX += nextL) {
                calculate(nextX, nextY, nextL);
            }
        }
    }

    private static Byte check(int startX, int startY, int length) {
        byte currentNumber = papers[startY][startX];

        for (int y = startY; y < startY + length; ++y) {
            for (int x = startX; x < startX + length; ++x) {
                if (papers[y][x] != currentNumber) {
                    return null;
                }
            }
        }

        return currentNumber;
    }
}
