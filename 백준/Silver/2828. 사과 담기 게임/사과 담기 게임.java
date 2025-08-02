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
        final int J = Integer.parseInt(br.readLine());
        int distance = 0;
        int leftPos = 1;
        int rightPos = leftPos + M - 1;

        for (int i = 0; i < J; ++i) {
            int pos = Integer.parseInt(br.readLine());

            if (leftPos <= pos && pos <= rightPos) {
                continue;
            }

            int step;
            if (pos > rightPos) {
                step = pos - rightPos;
                distance += step;
                leftPos += step;
                rightPos = leftPos + M - 1;
            } else {
                step = leftPos - pos;
                distance += step;
                leftPos -= step;
                rightPos = leftPos + M - 1;
            }
        }

        bw.write(String.valueOf(distance));
    }
}
