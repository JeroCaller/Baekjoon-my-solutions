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
        String[] conditions = br.readLine().split(" ");
        final int N = Integer.parseInt(conditions[0]);
        final int M = Integer.parseInt(conditions[1]);
        int numOfTwos = legendre(2, N) - legendre(2, N - M) - legendre(2, M);
        int numOfFives = legendre(5, N) - legendre(5, N - M) - legendre(5, M);

        bw.write(String.valueOf(Math.min(numOfTwos, numOfFives)));
    }

    private static int legendre(int p, int n) {
        int limit = (int) (Math.log(n) / Math.log(p));
        int memo = 1;
        int result = 0;

        for (int i = 1; i <= limit; ++i) {
            memo *= p;
            result += n / memo;
        }

        return result;
    }
}
