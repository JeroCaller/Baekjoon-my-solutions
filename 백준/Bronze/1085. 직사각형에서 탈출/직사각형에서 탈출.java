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
        String[] source = br.readLine().split(" ");
        int[] xy = getCoordsPair(0, source);
        int[] wh = getCoordsPair(2, source);

        final int H = 0;
        final int V = 1;
        int[] results = {0, 0};
        results[H] = Math.min(xy[H], wh[H] - xy[H]);
        results[V] = Math.min(xy[V], wh[V] - xy[V]);

        int result = Math.min(results[H], results[V]);
        bw.write(String.valueOf(result));

    }

    public static int[] getCoordsPair(int startIdx, String[] source) {
        int[] coords = new int[2];
        for (int i = startIdx; i < startIdx + 2; ++i) {
            coords[i - startIdx] = Integer.parseInt(source[i]);
        }
        return coords;
    }

}
