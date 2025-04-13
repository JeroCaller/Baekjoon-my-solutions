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

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        final int LIMIT = 2 * N - 1;
        final int Q = LIMIT / 2;

        for (int i = 1; i <= Q + 1; ++i) {
            int stars = 2 * i - 1;
            int spaces = (LIMIT - stars) / 2;
            appendOneLine(stars, spaces);
        }

        for (int k = Q; k > 0; --k) {
            int reversedStars = 2 * k - 1;
            int reversedSpaces = (LIMIT - reversedStars) / 2;
            appendOneLine(reversedStars, reversedSpaces);
        }

        bw.write(stringBuilder.toString());
    }

    public static void appendOneLine(int stars, int spaces) {
        stringBuilder.append(" ".repeat(spaces))
            .append("*".repeat(stars))
            .append("\n");
    }

}
