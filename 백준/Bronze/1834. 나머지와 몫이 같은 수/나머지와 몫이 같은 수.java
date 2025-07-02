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
        final long N = Long.parseLong(br.readLine());
        long answer = (N + 1) * getSumOneTo(N - 1);
        bw.write(String.valueOf(answer));
    }

    public static long getSumOneTo(long n) {
        return (n + 1) * n / 2;
    }
}