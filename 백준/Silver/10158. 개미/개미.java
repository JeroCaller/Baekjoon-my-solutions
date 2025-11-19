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
        final byte X = 0;
        final byte Y = 1;
        int[] wh = fromStringTokenToArray(br.readLine().split(" "));
        int[] pq = fromStringTokenToArray(br.readLine().split(" "));
        int t = Integer.parseInt(br.readLine());

        pq[X] = getFinalPos(pq[X], wh[X], t);
        pq[Y] = getFinalPos(pq[Y], wh[Y], t);

        bw.write(String.format("%s %s", pq[X], pq[Y]));
    }

    private static int[] fromStringTokenToArray(String[] tokens) {
        int[] array = new int[tokens.length];

        for (int i = 0; i < tokens.length; ++i) {
            array[i] = Integer.parseInt(tokens[i]);
        }

        return array;
    }

    private static int getFinalPos(int currentPos, int boundary, int t) {
        int finalPos = (currentPos + t) % (2 * boundary);

        return (finalPos > boundary) ? (2 * boundary) - finalPos : finalPos;
    }
}
