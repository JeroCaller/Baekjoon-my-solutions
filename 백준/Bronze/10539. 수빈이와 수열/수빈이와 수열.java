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
        final int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] b = new int[N];
        for (int i = 0; i < N; ++i) {
            b[i] = Integer.parseInt(inputs[i]);
        }

        int[] a = new int[N];
        a[0] = b[0];
        for (int i = 1; i < N; ++i) {
            int total = 0;
            for (int j = 0; j < i; ++j) {
                total += a[j];
            }
            a[i] = b[i] * (i + 1) - total;
        }

        for (int i = 0; i < N; ++i) {
            bw.write(a[i] + " ");
        }
    }
}