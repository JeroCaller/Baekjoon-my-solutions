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
        // if A < 0,
        // t = |A| * C + D + B * E

        // if A > 0,
        // t = (B - A) * E

        int[] n = new int[5];
        for (int i = 0; i < 5; ++i) {
            n[i] = Integer.parseInt(br.readLine());
        }

        int result;
        if (n[0] < 0) {
            result = Math.abs(n[0]) * n[2] + n[3] + n[1] * n[4];
        } else {
            result = (n[1] - n[0]) * n[4];
        }

        bw.write(String.valueOf(result));
    }

}
