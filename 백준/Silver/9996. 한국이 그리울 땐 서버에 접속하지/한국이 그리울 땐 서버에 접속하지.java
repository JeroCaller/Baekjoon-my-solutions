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
        final String[] patternTokens = br.readLine().split("\\*");

        for (int i = 0; i < N; ++i) {
            String target = br.readLine();

            if (patternTokens[0].length() + patternTokens[1].length() > target.length()) {
                bw.write("NE");
                bw.newLine();
                continue;
            }

            if (patternTokens[0].equals(target.substring(0, patternTokens[0].length())) &&
                patternTokens[1].equals(target.substring(
                    target.length() - patternTokens[1].length()))
            ) {
                bw.write("DA");
            } else {
                bw.write("NE");
            }

            bw.newLine();
        }
    }
}
