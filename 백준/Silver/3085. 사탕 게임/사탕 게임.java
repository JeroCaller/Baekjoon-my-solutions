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

    private static char[][] map;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        int maximum = 1;

        outer : for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int[][] adjacentIdx = {{i, j + 1}, {i + 1, j}};
                int[] currentIdx = {i, j};  // r, c

                maximum = Math.max(maximum, findMax(currentIdx));
                if (maximum == N) break outer;

                for (int k = 0; k < 2; ++k) {
                    try {
                        swap(currentIdx, adjacentIdx[k]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }

                    maximum = Math.max(
                        maximum,
                        Math.max(findMax(currentIdx), findMax(adjacentIdx[k]))
                    );
                    swap(currentIdx, adjacentIdx[k]);

                    if (maximum == N) break outer;
                }
            }
        }

        bw.write(String.valueOf(maximum));
    }

    private static void swap(int[] a, int[] b) {
        char temp = map[a[0]][a[1]];
        map[a[0]][a[1]] = map[b[0]][b[1]];
        map[b[0]][b[1]] = temp;
    }

    private static int findMax(int[] rc) {
        int maximum = 1;

        for (int i = 0; i < 2; ++i) {
            char currentChar = getChar(i, rc, 0);
            int localMax = 1;
            int currentCount = 1;

            for (int j = 1; j < map.length; ++j) {
                char nextChar = getChar(i, rc, j);

                if (currentChar == nextChar) {
                    currentCount++;
                } else {
                    localMax = Math.max(localMax, currentCount);
                    currentChar = nextChar;
                    currentCount = 1;
                }
            }

            localMax = Math.max(localMax, currentCount);
            maximum = Math.max(maximum, localMax);
        }

        return maximum;
    }

    private static char getChar(int trial, int[] rc, int i) {
        return (trial == 0) ? map[rc[0]][i] : map[i][rc[1]];
    }
}
