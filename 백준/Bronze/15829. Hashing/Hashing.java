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

    private static final int R = 31;
    private static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int L = Integer.parseInt(br.readLine());
        String source = br.readLine();
        int result = hash(source);
        bw.write(String.valueOf(result));
    }

    public static int hash(String source) {
        int seriesSum = 0;
        for (int i = 0; i < source.length(); ++i) {
            int a = source.charAt(i) - 'a' + 1;
            seriesSum += (int) (a * Math.pow(R, i));
        }
        return seriesSum % M;
    }
}