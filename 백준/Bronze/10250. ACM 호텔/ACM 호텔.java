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
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int[] inputs = parseSource(br.readLine().split(" "));
            final int H = inputs[0];
            final int W = inputs[1];
            final int N = inputs[2];

            int q = N / H;
            int r = N % H;
            String x, y;

            if (r == 0) {
                x = (q < 10) ? "0" + String.valueOf(q) : String.valueOf(q);
                y = String.valueOf(H);
            } else {
                x = (q + 1 < 10) ? "0" + String.valueOf(q + 1) :
                    String.valueOf(q + 1);
                y = String.valueOf(r);
            }

            bw.write(y + x);
            bw.newLine();
        }
    }

    public static int[] parseSource(String[] source) {
        int[] inputs = new int[source.length];
        for (int i = 0; i < source.length; ++i) {
            inputs[i] = Integer.parseInt(source[i]);
        }
        return inputs;
    }

}
