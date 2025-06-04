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

    private static int numOfCallFunc = 0;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            String source = br.readLine();
            bw.write(isPalindrome(source) + " " + numOfCallFunc);
            bw.newLine();
            numOfCallFunc = 0;
        }
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static int recursion(String s, int l, int r) {
        ++numOfCallFunc;
        if (l >= r) return 1;
        if (s.charAt(l) != s.charAt(r)) return 0;
        return recursion(s, l + 1, r - 1);
    }
}