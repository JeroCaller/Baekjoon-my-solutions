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
        // index
        final int X = 0;
        final int Y = 1;

        final int N = Integer.parseInt(br.readLine());
        final int T = Integer.parseInt(br.readLine());
        final int CENTER_POS = N / 2;
        int[][] array = new int[N][N];
        int[] targetPos = {CENTER_POS, CENTER_POS};   // {X, Y}
        int count = 1;
        int radius = 0;
        int[] nextDxdy = {0, 0};

        while (count <= N * N) {
            if (nextDxdy[X] == -radius && nextDxdy[Y] == -radius) {
                if (count == T) {
                    targetPos[X] = CENTER_POS + nextDxdy[X];
                    targetPos[Y] = CENTER_POS + nextDxdy[Y];
                }

                array[CENTER_POS + nextDxdy[Y]--][CENTER_POS + nextDxdy[X]] = count++;
                ++radius;
                continue;
            }

            if (nextDxdy[X] < radius && nextDxdy[Y] == -radius) {
                while (nextDxdy[X] < radius) {
                    if (count == T) {
                        targetPos[X] = CENTER_POS + nextDxdy[X];
                        targetPos[Y] = CENTER_POS + nextDxdy[Y];
                    }

                    array[CENTER_POS + nextDxdy[Y]][CENTER_POS + nextDxdy[X]++] = count++;
                }
            } else if (nextDxdy[X] == radius && nextDxdy[Y] == -radius) {
                while (nextDxdy[Y] < radius) {
                    if (count == T) {
                        targetPos[X] = CENTER_POS + nextDxdy[X];
                        targetPos[Y] = CENTER_POS + nextDxdy[Y];
                    }

                    array[CENTER_POS + nextDxdy[Y]++][CENTER_POS + nextDxdy[X]] = count++;
                }
            } else if (nextDxdy[X] == radius && nextDxdy[Y] == radius) {
                while (nextDxdy[X] > -radius) {
                    if (count == T) {
                        targetPos[X] = CENTER_POS + nextDxdy[X];
                        targetPos[Y] = CENTER_POS + nextDxdy[Y];
                    }

                    array[CENTER_POS + nextDxdy[Y]][CENTER_POS + nextDxdy[X]--] = count++;
                }
            } else if (nextDxdy[X] == -radius && nextDxdy[Y] == radius) {
                while (nextDxdy[Y] > -radius) {
                    if (count == T) {
                        targetPos[X] = CENTER_POS + nextDxdy[X];
                        targetPos[Y] = CENTER_POS + nextDxdy[Y];
                    }

                    array[CENTER_POS + nextDxdy[Y]--][CENTER_POS + nextDxdy[X]] = count++;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                bw.write(array[i][j] + " ");
            }

            bw.newLine();
        }

        bw.write(String.format("%d %d", targetPos[Y] + 1, targetPos[X] + 1));
    }
}
