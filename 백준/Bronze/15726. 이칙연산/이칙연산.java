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
        int[] n = new int[3];

        for (int i = 0; i < 3; ++i) {
            n[i] = Integer.parseInt(source[i]);
        }

        double result = Math.max(
            (double) n[0] * n[1] / n[2],
            (double) n[0] / n[1] * n[2]
        );
        bw.write(String.valueOf((int) result));
    }

}
