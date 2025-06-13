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
        String source = br.readLine();
        String pattern = br.readLine();
        bw.write(String.valueOf(hasPatternByKMP(source, pattern)));
    }

    public static int hasPatternByKMP(String source, String pattern) {
        int[] table = getTable(pattern);
        final int S = source.length();
        final int P = pattern.length();

        int start = 0;
        for (int i = 0; i < S; ++i) {
            while (start > 0 && source.charAt(i) != pattern.charAt(start)) {
                start = table[start - 1];
            }

            if (source.charAt(i) == pattern.charAt(start)) {
                if (start == P - 1) {
                    return 1;
                }
                ++start;
            }
        }
        return 0;
    }

    public static int[] getTable(String pattern) {
        final int N = pattern.length();
        int[] table = new int[N];

        int start = 0;
        for (int i = 1; i < N; ++i) {
            while (start > 0 && pattern.charAt(start) != pattern.charAt(i)) {
                start = table[start - 1];
            }

            if (pattern.charAt(start) == pattern.charAt(i)) {
                table[i] = ++start;
            }
        }

        return table;
    }
}