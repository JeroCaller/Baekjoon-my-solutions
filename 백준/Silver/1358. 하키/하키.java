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
        final int W = Integer.parseInt(firstLine[0]);
        final int H = Integer.parseInt(firstLine[1]);
        final int X = Integer.parseInt(firstLine[2]);
        final int Y = Integer.parseInt(firstLine[3]);
        final int P = Integer.parseInt(firstLine[4]);
        final int R = H / 2;

        int count = 0;

        for (int i = 0; i < P; ++i) {
            String[] inputs = br.readLine().split(" ");
            final int X_PRIME = Integer.parseInt(inputs[0]);
            final int Y_PRIME = Integer.parseInt(inputs[1]);
            boolean yCondition = Y <= Y_PRIME && Y_PRIME <= Y + H;

            if ((X - R <= X_PRIME && X_PRIME <= X) && yCondition) {
                if (getSquareOf(X_PRIME - X) + getSquareOf(Y_PRIME - Y - R) <= getSquareOf(R)) {
                    ++count;
                }
            } else if ((X <= X_PRIME && X_PRIME <= X + W) && yCondition) {
                ++count;
            } else if ((X + W <= X_PRIME && X_PRIME <= X + W + R) && yCondition) {
                if (getSquareOf(X_PRIME - X - W) + getSquareOf(Y_PRIME - Y - R) <= getSquareOf(R)) {
                    ++count;
                }
            }
        }

        bw.write(String.valueOf(count));
    }

    private static int getSquareOf(int n) {
        return n * n;
    }
}
