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
        long N = Long.parseLong(br.readLine());
        long result = fact(N);
        bw.write(String.valueOf(result));
    }

    public static long fact(long N) {
        if (N == 0 || N == 1) {
            return 1;
        }
        return N * fact(N - 1);
    }

}
