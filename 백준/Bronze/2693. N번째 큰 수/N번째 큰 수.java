import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        final int T = Integer.parseInt(br.readLine());
        int[] a = new int[10];

        for (int i = 0; i < T; ++i) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; ++j) {
                a[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(a);
            bw.write(String.valueOf(a[a.length - 3]));
            bw.newLine();
        }
    }
}