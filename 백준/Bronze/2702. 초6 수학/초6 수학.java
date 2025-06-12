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
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            String[] oneLine = br.readLine().split(" ");
            int a = Integer.parseInt(oneLine[0]);
            int b = Integer.parseInt(oneLine[1]);

            int gcd = getGCD(a, b);
            int lcd = a * b / gcd;
            bw.write(lcd + " " + gcd);
            bw.newLine();
        }
    }

    public static int getGCD(int a, int b) {
        int r = Math.max(a, b) % Math.min(a, b);
        if (r == 0) {
            return Math.min(a, b);
        }
        return getGCD(Math.min(a, b), r);
    }
}