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
        String[] inputs = br.readLine().split(" ");
        final int X = Integer.parseInt(inputs[0]);
        final int Y = Integer.parseInt(inputs[1]);
        final long Z = (Y * 100L) / X;
        int answer = -1;

        if (X == Y) {
            bw.write(String.valueOf(answer));
            return;
        }

        int lowIdx = 0;
        int highIdx = 1000000000 + 1;
        int midIdx;
        long newZ;

        while (lowIdx + 1 < highIdx) {
            midIdx = (lowIdx + highIdx) / 2;
            newZ = ((Y + midIdx) * 100L) / (X + midIdx);

            if (newZ != Z) {
                if (answer == -1 || answer > midIdx) {
                    answer = midIdx;
                }

                highIdx = midIdx;
            } else {
                lowIdx = midIdx;
            }
        }

        bw.write(String.valueOf(answer));
    }
}
